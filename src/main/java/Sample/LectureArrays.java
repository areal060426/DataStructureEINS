package Sample;

public class LectureArrays {

	public static void main(String[] args) {
		// 1D Array [rows/index]
		// 2D Array [rows][columns]
		// 3D Multi Dimensional [layer][rows][columns]
		
		// 2D Array
		
		int[][] grade = {
			  // 0  1  2 columns
				{90,95,88},  // 0 rows
				{75,80,82},  // 1
				{95,91,93}   // 2
		};
		
		System.out.print("Grade: " + grade[1][1] + "\n");
		System.out.print("Grade: " + grade[2][2] + "\n");
		System.out.print("Grade: " + grade[0][2] + "\n");
		
		
		// Modifying 2D Arrays 
		grade[0][2]= 93;
		System.out.print("Grade: " + grade[0][2] + "\n");
		grade[2][2] = 68;
		System.out.print("Grade: " + grade[2][2] + "\n");
		
		// Printing all values
		for (int row = 0; row < grade.length; row++) {
			for(int column = 0; column < grade[row].length; column++) {
				System.out.print(grade[row][column] + " ");
			}
			System.out.println();
		}
		
		// 3D Arrays or Multi Dimensional
		/*
		 * Semester 1 -> Layer 0
		 * Student 1 : 90 85 88
		 * Student 2 : 75 80 82
		 * 
		 * Semester 2 -> Layer 1
		 * Student 1 : 95 91 93
		 * Student 2 : 87 89 90
		 * */
		
		int[][][] grades = {
				{ // Layer 0
				 //  0  1  2
					{90,85,88}, // 0
					{75,80,82}  // 1
				},
				{// layer 1
				 //  0  1  2
					{95,91,93}, // 0
					{87,89,90}  // 1
				}
						  };

		System.out.print("Grades: " + grades[0][0][2] + "\n");
		System.out.print("Grades: " + grades[1][0][1] + "\n");
		
		// Modifying 3D Arrays
		
		grades[0][0][2]=93;
		System.out.print("Grades: " + grades[0][0][2] + "\n");
	}
}
