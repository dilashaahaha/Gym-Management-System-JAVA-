/**This class RegularMember is a child class of GymMember. It consists of various methods to manipulate various value sreferring to the 
   attributes of a regular member**/

public class RegularMember extends GymMember
{
    final int attendanceLimit;
    boolean isEligibleForUpgrade;
    String removalReason;
    String referralSource;
    String plan;
    double price;
   //constructor
   RegularMember(int id, String name, String location, String phone, String email,String gender, String DOB,String membershipStartDate, 
   String referralSource){
     super(id,name,location,phone,email,gender,DOB,membershipStartDate);
     this.isEligibleForUpgrade=false;
     this.attendanceLimit=30;
     this.plan="Basic";
     this.price=6500.0;
     this.removalReason=" ";
     this.referralSource=referralSource;
   }
   //individual accessor methods
   public int getAttendanceLimit(){
       return attendanceLimit;
   }
   public boolean getIsEligibleForUpgrade(){
       return isEligibleForUpgrade;
   }
   public String getRemovalReason(){
       return removalReason;
   }
   public String getReferralSource(){
       return referralSource;
   }
   public String getPlan(){
       return plan;
   }
   public double getPrice(){
       return price;
   }
   //to display the price of chosen plan
   public double getPlanPrice(String plan){
       switch(plan.toLowerCase()){
           case "basic":
               return 6500.0;
            case "standard":
                return 12500.0;
            case "deluxe":
                return 18500.0;
            default:
                return -1;
       }
   }
   public String upgradePlan(String newPlan){
       if(attendance>=attendanceLimit){
           isEligibleForUpgrade= true;
       }
       if(!isEligibleForUpgrade){
           return "Member is not eligible for an upgrade";
       }
       if(plan.equalsIgnoreCase(newPlan)){
           return "You are already subscribed to this plan";
       }
       double newPrice = getPlanPrice(newPlan);
       if(newPrice ==-1){
           return "invalid plan selected";
       }
       this.plan=newPlan;
       this.price=newPrice;
       return "Plan successfully upgraded to" +newPlan+ "for" +newPrice;
   }
   public void revertRegularMember(String removalReason){
       resetMember();
       this.isEligibleForUpgrade =false;
       this.plan="Basic";
       this.price=6500.0;
       this.removalReason=removalReason;
   }
   @Override
   public void markAttendance(){
       if(attendance<attendanceLimit){
           attendance++;
           loyaltyPoints+=5;}
           else{
               System.out.println("Attendance limit reached for regular member.");
           }
       }
     @Override
     public void display(){
         super.display();
         System.out.println("Plan:"+plan);
         System.out.println("Price:"+price);
         if(!removalReason.isEmpty()){
             System.out.println("Removal reason:"+removalReason);
         }
     }
   }


