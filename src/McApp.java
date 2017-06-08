import java.util.Scanner;

public class McApp {

	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);
		Database db=new Database();
		System.out.println("What would you like to do to the database?\n"
				+ "Enter 1 to add a student\n"
				+ "Enter 2 to edit a student\n"
				+ "Enter 3 to delete a student\n"
				+ "Enter 4 to find a student\n"
				+ "Enter anything else to quit");
		String input1=sc.nextLine();
		if(input1.equals("1"))
		{
			System.out.println("Please input the student's first name");
			String first=sc.nextLine();
			
			System.out.println("Please input the student's last name");
			String last=sc.nextLine();
			
			System.out.println("Please input the student's street address");
			String address=sc.nextLine();
			
			System.out.println("Please input the student's city");
			String city=sc.nextLine();
			
			System.out.println("Please input the student's state");
			String state=sc.nextLine();
			
			System.out.println("Please input the student's zip code");
			String zip=sc.nextLine();
			
			System.out.println("Please input the student's phone number");
			String phone=sc.nextLine();
			
			System.out.println("Please input the student's department id");
			String deptID=sc.nextLine();
			
			System.out.println("Please input the student's major");
			String major=sc.nextLine();
			
			db.addStudent(first, last, address, city, state, zip, phone, major, deptID);
			
			
		}
		else if(input1.equals("2"))
		{
			System.out.println("Please input the student's id number");
			String id=sc.nextLine();
			
			String[]vals= db.getStudent(Integer.parseInt(id));
			
			System.out.println("Please input desired First Name. If no change enter 'N'");
			String first=sc.nextLine();
			
			if(!first.equals("N"))
			{
				vals[0]=first;
			}
			
			System.out.println("Please input desired Last Name. If no change enter 'N'");
			String last=sc.nextLine();
			
			if(!last.equals("N"))
			{
				vals[1]=last;
			}
			System.out.println("Please input desired Address. If no change enter 'N'");
			String add=sc.nextLine();
			
			if(!add.equals("N"))
			{
				vals[2]=add;
			}
			System.out.println("Please input desired City. If no change enter 'N'");
			String city=sc.nextLine();
			
			if(!city.equals("N"))
			{
				vals[3]=city;
			}
			System.out.println("Please input desired State. If no change enter 'N'");
			String state=sc.nextLine();
			
			if(!state.equals("N"))
			{
				vals[4]=state;
			}
			System.out.println("Please input desired ZIP. If no change enter 'N'");
			String zip=sc.nextLine();
			
			if(!zip.equals("N"))
			{
				vals[5]=zip;
			}
			System.out.println("Please input desired Phone. If no change enter 'N'");
			String phone=sc.nextLine();
			
			if(!phone.equals("N"))
			{
				vals[6]=phone;
			}
			System.out.println("Please input desired Department ID. If no change enter 'N'");
			String depid=sc.nextLine();
			
			if(!depid.equals("N"))
			{
				vals[8]=depid;
			}
			System.out.println("Please input desired Major. If no change enter 'N'");
			String major=sc.nextLine();
			
			if(!major.equals("N"))
			{
				vals[9]=major;
			}
			
			db.updateStudent(vals[0], vals[1], vals[2],vals[3], vals[4], vals[5], vals[6], vals[7], vals[8], vals[9]);
			
			
		}
		else if(input1.equals("3"))
		{
			System.out.println("Please input the student's id number to delete");
			String id=sc.nextLine();
			
			System.out.println("Please confirm the student's id number");
			String check=sc.nextLine();
			
			if(check.equals(id))
			{
				if(db.deleteStudent(Integer.parseInt(id)))
				{
					
				System.out.println("The student with id "+id+" was deleted successfully");
				}
			}
			else
			{
				System.out.println("The two ids did not match. Please enter again");
			}
			
			
			
		}
		else if(input1.equals("4"))
		{
			System.out.println("Please input the student's id number");
			String id=sc.nextLine();
			
			String[]vals= db.getStudent(Integer.parseInt(id));
			for(int i=0;i<vals.length;i++)
			{
				System.out.print(vals[i] + "\t");
			}

			
		}
		else
		{
			System.out.println("You have chosen to quit!  Have nice day!");
		}
		
		
		
	}
		
	
}
