package NaLeEganFinalsProject;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.text.AbstractDocument;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;
import java.awt.*;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// Container class para sa bawat ticket/order node sa Queue
class Order {
    int ticketNumber;
    String customerName;
    String itemDetails;
    String timePlaced;

    public Order(int ticketNumber, String customerName, String itemDetails) {
        this.ticketNumber = ticketNumber;
        this.customerName = customerName;
        this.itemDetails = itemDetails;
        this.timePlaced = LocalTime.now().format(DateTimeFormatter.ofPattern("hh:mm a"));
    }

    @Override
    public String toString() {
        return String.format("[#%d] %s — %s (%s)", ticketNumber, customerName, itemDetails, timePlaced);
    }
}

public class DeliveryTicketingGUI extends JFrame {

    // Core Data Structure: Queue (FIFO - First In, First Out)
    private Queue<Order> orderQueue = new LinkedList<>();
    // Secondary list para ma-track yung mga na-dispatch na orders
    private List<Order> completedOrders = new ArrayList<>();
    private int nextTicketId = 101;

    // Preset Menu Items para may pagpipilian yung customer
    private final String[] MENU_ITEMS = {
            "Yangnyeom Boneless Chicken (₱165)",
            "Snow Cheese Boneless Chicken (₱165)",
            "Jack Daniels Boneless Chicken (₱165)",
            "Spicy Cheese Boneless Chicken (₱165)",
            "Original Boneless Chicken (₱155)",
            "Half & Half Box — 14 pcs (₱320)",
            "Barkada Box — 28 pcs (₱620)"
    };

    // GUI Components
    private JTextField nameField;
    private JComboBox<String> menuComboBox;
    private JSpinner qtySpinner;
    private JTextArea queueDisplayArea;
    private JTextArea historyDisplayArea;
    private JLabel sizeLabel;
    private JLabel frontLabel;
    private JLabel rearLabel;

    public DeliveryTicketingGUI() {
        setTitle("Delivery Order Ticketing System — Queue (FIFO) Implementation");
        setSize(860, 540);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Auto-center yung window pagka-open
        setLayout(new BorderLayout(10, 10));

        // Pre-loaded sample orders para ready na agad i-demo sa presentation
        enqueueOrder("Alice", "1x Yangnyeom Boneless Chicken (₱165)");
        enqueueOrder("Bob", "2x Snow Cheese Boneless Chicken (₱165)");
        enqueueOrder("Charlie", "1x Jack Daniels Boneless Chicken (₱165)");

        // ================= TOP SECTION: STATS + LOGO + INPUTS =================
        JPanel topContainer = new JPanel(new BorderLayout(10, 10));
        topContainer.setBorder(new EmptyBorder(12, 12, 0, 12));

        // --- IMAGE / LOGO SECTION (From Aldrin's update) ---
        ImageIcon originalIcon = new ImageIcon("swiftdeliver_logo.png");
        Image scaledImage = originalIcon.getImage().getScaledInstance(-1, 80, Image.SCALE_SMOOTH);
        JLabel imageLabel = new JLabel(new ImageIcon(scaledImage));
        imageLabel.setBorder(new EmptyBorder(0, 4, 0, 4));
        topContainer.add(imageLabel, BorderLayout.WEST);

        // 1. Live Queue Pointers Bar (Demonstrates peek(), size(), Front, and Rear)
        JPanel statsPanel = new JPanel(new GridLayout(1, 3, 10, 0));
        statsPanel.setBackground(new Color(30, 41, 59));
        statsPanel.setBorder(new EmptyBorder(10, 14, 10, 14));

        sizeLabel = createStatLabel("QUEUE SIZE: 0");
        frontLabel = createStatLabel("HEAD (PEEK): None");
        rearLabel = createStatLabel("TAIL (LAST): None");

        statsPanel.add(sizeLabel);
        statsPanel.add(frontLabel);
        statsPanel.add(rearLabel);
        topContainer.add(statsPanel, BorderLayout.NORTH);

        // 2. Order Input & Menu Selection Controls
        JPanel inputPanel = new JPanel(new GridBagLayout());
        inputPanel.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(new Color(180, 180, 180)),
                "New Delivery Ticket (Select from Menu)",
                TitledBorder.LEFT,
                TitledBorder.TOP,
                new Font("SansSerif", Font.BOLD, 12)
        ));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(6, 6, 6, 6);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Customer Name (Letters, spaces, periods, and hyphens only)
        gbc.gridx = 0; gbc.gridy = 0; gbc.weightx = 0.12;
        inputPanel.add(new JLabel("Customer Name:"), gbc);

        gbc.gridx = 1; gbc.gridy = 0; gbc.weightx = 0.25;
        nameField = new JTextField();
        applyLetterOnlyFilter(nameField);
        inputPanel.add(nameField, gbc);

        // Menu Dropdown
        gbc.gridx = 2; gbc.gridy = 0; gbc.weightx = 0.10;
        inputPanel.add(new JLabel("Menu Item:"), gbc);

        gbc.gridx = 3; gbc.gridy = 0; gbc.weightx = 0.38;
        menuComboBox = new JComboBox<>(MENU_ITEMS);
        menuComboBox.setBackground(Color.WHITE);
        inputPanel.add(menuComboBox, gbc);

        // Quantity Spinner
        gbc.gridx = 4; gbc.gridy = 0; gbc.weightx = 0.05;
        inputPanel.add(new JLabel("Qty:"), gbc);

        gbc.gridx = 5; gbc.gridy = 0; gbc.weightx = 0.10;
        qtySpinner = new JSpinner(new SpinnerNumberModel(1, 1, 20, 1));
        inputPanel.add(qtySpinner, gbc);

        // Action Buttons
        JPanel buttonPanel = new JPanel(new GridLayout(1, 3, 10, 0));
        JButton enqueueBtn = new JButton("+ Add Order (Enqueue)");
        enqueueBtn.setBackground(new Color(22, 163, 74));
        enqueueBtn.setForeground(Color.WHITE);
        enqueueBtn.setFocusPainted(false);
        enqueueBtn.setFont(new Font("SansSerif", Font.BOLD, 12));

        JButton dequeueBtn = new JButton("Dispatch Next (Dequeue)");
        dequeueBtn.setBackground(new Color(37, 99, 235));
        dequeueBtn.setForeground(Color.WHITE);
        dequeueBtn.setFocusPainted(false);
        dequeueBtn.setFont(new Font("SansSerif", Font.BOLD, 12));

        JButton peekBtn = new JButton("Inspect Next (Peek)");
        peekBtn.setFocusPainted(false);
        peekBtn.setFont(new Font("SansSerif", Font.BOLD, 12));

        buttonPanel.add(enqueueBtn);
        buttonPanel.add(dequeueBtn);
        buttonPanel.add(peekBtn);

        gbc.gridx = 0; gbc.gridy = 1; gbc.gridwidth = 6;
        inputPanel.add(buttonPanel, gbc);

        topContainer.add(inputPanel, BorderLayout.CENTER);
        add(topContainer, BorderLayout.NORTH);

        // ================= CENTER SECTION: SPLIT QUEUE & HISTORY =================
        JPanel centerPanel = new JPanel(new GridLayout(1, 2, 12, 0));
        centerPanel.setBorder(new EmptyBorder(0, 12, 12, 12));

        // Left: Active Queue (FIFO Lineup)
        queueDisplayArea = new JTextArea();
        queueDisplayArea.setEditable(false);
        queueDisplayArea.setFont(new Font("Consolas", Font.PLAIN, 13));
        queueDisplayArea.setMargin(new Insets(8, 8, 8, 8));
        JScrollPane queueScroll = new JScrollPane(queueDisplayArea);
        queueScroll.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(new Color(37, 99, 235), 2),
                "Active Pending Queue (FIFO — Front to Back)",
                TitledBorder.LEFT,
                TitledBorder.TOP,
                new Font("SansSerif", Font.BOLD, 12),
                new Color(37, 99, 235)
        ));

        // Right: Dispatched Log
        historyDisplayArea = new JTextArea();
        historyDisplayArea.setEditable(false);
        historyDisplayArea.setFont(new Font("Consolas", Font.PLAIN, 13));
        historyDisplayArea.setMargin(new Insets(8, 8, 8, 8));
        historyDisplayArea.setBackground(new Color(248, 250, 252));
        JScrollPane historyScroll = new JScrollPane(historyDisplayArea);
        historyScroll.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(new Color(100, 116, 139)),
                "Dispatched Orders Log (Completed)",
                TitledBorder.LEFT,
                TitledBorder.TOP,
                new Font("SansSerif", Font.BOLD, 12),
                new Color(71, 85, 105)
        ));

        centerPanel.add(queueScroll);
        centerPanel.add(historyScroll);
        add(centerPanel, BorderLayout.CENTER);

        // Initial render
        refreshDisplays();

        // ================= EVENT LISTENERS =================

        // ENQUEUE: Add sa pinaka-likod (Tail) ng Queue
        enqueueBtn.addActionListener(e -> {
            String name = nameField.getText().trim();
            String selectedItem = (String) menuComboBox.getSelectedItem();
            int qty = (int) qtySpinner.getValue();

            if (name.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please enter a valid Customer Name (letters only).", "Missing Input", JOptionPane.WARNING_MESSAGE);
                return;
            }

            String formattedOrder = qty + "x " + selectedItem;
            Order created = enqueueOrder(name, formattedOrder);

            // Reset inputs for next customer
            nameField.setText("");
            menuComboBox.setSelectedIndex(0);
            qtySpinner.setValue(1);
            nameField.requestFocus();

            refreshDisplays();
            JOptionPane.showMessageDialog(this, "Ticket #" + created.ticketNumber + " (" + formattedOrder + ") added to the REAR of the queue.", "Enqueued", JOptionPane.INFORMATION_MESSAGE);
        });

        // DEQUEUE: Kunin at alisin yung nasa pinaka-unahan (Head) ng Queue
        dequeueBtn.addActionListener(e -> {
            Order dispatched = orderQueue.poll(); // poll() removes and returns the head
            if (dispatched != null) {
                completedOrders.add(0, dispatched); // Ilagay sa top ng completed log
                refreshDisplays();
                JOptionPane.showMessageDialog(this,
                        "DISPATCHED FROM FRONT:\n" + dispatched.toString(),
                        "Order Dispatched (Dequeued)",
                        JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "Queue is currently empty. Nothing to dispatch.", "Empty Queue", JOptionPane.WARNING_MESSAGE);
            }
        });

        // PEEK: Silipin lang yung susunod na ide-dispatch nang hindi tinatanggal sa Queue
        peekBtn.addActionListener(e -> {
            Order nextOrder = orderQueue.peek(); // peek() reads the head without removing it
            if (nextOrder != null) {
                JOptionPane.showMessageDialog(this,
                        "NEXT IN LINE (HEAD / FRONT):\n" + nextOrder.toString() + "\n\n(Note: Order remains in queue until dispatched.)",
                        "Queue Peek",
                        JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "Queue is empty.", "Queue Peek", JOptionPane.INFORMATION_MESSAGE);
            }
        });
    }

    // Input filter: pinapayagan lang yung letters (including Ñ/ñ), spaces, periods, at hyphens
    private void applyLetterOnlyFilter(JTextField field) {
        ((AbstractDocument) field.getDocument()).setDocumentFilter(new DocumentFilter() {
            private final String VALID_NAME_REGEX = "[a-zA-ZñÑ\\s.-]*";

            @Override
            public void insertString(FilterBypass fb, int offset, String string, AttributeSet attr) throws BadLocationException {
                if (string != null && string.matches(VALID_NAME_REGEX)) {
                    super.insertString(fb, offset, string, attr);
                } else {
                    Toolkit.getDefaultToolkit().beep();
                }
            }

            @Override
            public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
                if (text != null && text.matches(VALID_NAME_REGEX)) {
                    super.replace(fb, offset, length, text, attrs);
                } else {
                    Toolkit.getDefaultToolkit().beep();
                }
            }
        });
    }

    private Order enqueueOrder(String customerName, String itemDetails) {
        Order newOrder = new Order(nextTicketId++, customerName, itemDetails);
        orderQueue.add(newOrder);
        return newOrder;
    }

    private JLabel createStatLabel(String text) {
        JLabel label = new JLabel(text, SwingConstants.CENTER);
        label.setForeground(Color.WHITE);
        label.setFont(new Font("SansSerif", Font.BOLD, 12));
        return label;
    }

    // Ina-update yung UI panels at pointers every time magbago yung laman ng Queue
    private void refreshDisplays() {
        // Update Top Stats Bar
        sizeLabel.setText("QUEUE SIZE: " + orderQueue.size());

        Order head = orderQueue.peek();
        frontLabel.setText("HEAD (NEXT): " + (head != null ? "#" + head.ticketNumber + " " + head.customerName : "None"));

        Order tail = null;
        for (Order o : orderQueue) {
            tail = o; // Last element sa iteration yung Tail
        }
        rearLabel.setText("TAIL (LAST): " + (tail != null ? "#" + tail.ticketNumber + " " + tail.customerName : "None"));

        // Update Left Panel (Pending Queue)
        queueDisplayArea.setText("");
        if (orderQueue.isEmpty()) {
            queueDisplayArea.append("\n   [ Queue is empty — no pending orders ]\n");
        } else {
            int pos = 1;
            int total = orderQueue.size();
            for (Order o : orderQueue) {
                String marker = "";
                if (pos == 1) marker = "  <-- [FRONT / NEXT]";
                else if (pos == total) marker = "  <-- [REAR]";

                queueDisplayArea.append(pos + ". " + o.toString() + marker + "\n\n");
                pos++;
            }
        }

        // Update Right Panel (Dispatched History)
        historyDisplayArea.setText("");
        if (completedOrders.isEmpty()) {
            historyDisplayArea.append("\n   [ No orders dispatched yet ]\n");
        } else {
            for (Order o : completedOrders) {
                historyDisplayArea.append("✓ " + o.toString() + "\n\n");
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new DeliveryTicketingGUI().setVisible(true));
    }
}

