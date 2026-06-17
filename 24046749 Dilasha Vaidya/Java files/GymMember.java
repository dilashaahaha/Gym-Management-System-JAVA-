/**This class 'GymMember' is a abstract parent class that has two sub classes RegularMember and PremiumMember. This parent class has its
   primary attributes and methods that help carryout various functions in the aspired gym software design**/
   
public abstract class GymMember
{
   //attribues with prtectected access modifier
    protected int id;
   protected String name;
   protected String location;
   protected String phone;
   protected String email;
   protected String gender;
   protected String DOB;
   protected String membershipStartDate;
   protected int attendance;
   protected double loyaltyPoints;
   protected boolean activeStatus;
   //constructor
   GymMember(int id,String name, String location,String phone, 
   String email, String gender, String DOB,String membershipStartDate){
    //initializing the values of some attributes
    this.attendance=0;
    this.loyaltyPoints=0.0;
    this.activeStatus=false;
    //assigning parameter values
    this.id=id;
    this.name=name;
    this.location=location;
    this.phone=phone;
    this.email=email;
    this.gender=gender;
    this.DOB=DOB;
    this.membershipStartDate=membershipStartDate;
   }
   //making individual accessor methods for all the given attributes
   public int getId(){
       return id;
   }
   
   public String getName(){
       return name;
   }
   public String location(){
       return location;
   }
   public String phone(){
       return phone;
   }
   public String email(){
       return email;
   }
   public String email(String phone){
       return email;
   }
   public String gender(){
       return gender;
   }
   public String DOB(){
       return DOB;
   }
   public String membershipStartDate(){
       return membershipStartDate;
   }
   public int attendance(){
       return attendance;
   }
   public double loyaltyPoints(){
       return loyaltyPoints;
   }
   public boolean activeStatus(){
       return activeStatus;
   }
   //abstract method called markAttendance to track the attendance
   public abstract void markAttendance();
   //sets membershipStatus to active 
   public void activateMembership(){
       activeStatus= true;
   }
   //sets the membershipStatus to inactive if active and displays a message incase of already inactive
   public void deactivateMembership(){
       if (activeStatus){
           activeStatus= false;}
           else{
               System.out.println("Already inactive");
           }
       }
       //resets the values of the attributes of the member
       public void resetMember(){
           activeStatus= false;
           attendance=0;
           loyaltyPoints=0.0;
       }
       //displays the inserted values
       public void display(){
           System.out.println("ID:" +id);
           System.out.println("Name:"+name);
           System.out.println("Location:"+location);
           System.out.println("Phone:"+phone);
           System.out.println("Email:"+email);
           System.out.println("Gender:"+gender);
           System.out.println("Date Of Birth:"+DOB);
           System.out.println("Membership startdate:"+membershipStartDate);
           System.out.println("Attendance:"+attendance);
           System.out.println("Loyalty points:"+loyaltyPoints);
           System.out.println("Active Status:"+ (activeStatus? "Active":"Inactive"));
       }
}

