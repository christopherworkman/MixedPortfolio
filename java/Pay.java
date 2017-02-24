//Maria Bocanegra
//CIS 163AA


//calculate's an employee's pay per hours worked, after insurance deductions.

import javax.swing.JOptionPane;

public class Pay
{
    public static void main(String[] args)
    {
	
	String skillLevel, hrsWorked;
	int skillLevelInt, medicalIns, dentalIns, disabilityIns, retirementDeduct;
	double hrsWorkedDb;
    final int levelOne = 1, levelTwo = 2, levelThree = 3;
      
    double hourlyPay, regular40Hrs, overtimeHrs, overtimePay, totalPay, totalPaycheck; 
    double totalDeductions, totalInsuranceDeduction;
    boolean insuranceOptionElig, retirementOptionElig, validSkillEntry = false;
   
    String message;
   
   
    double medicalInsCost = 0, dentalInsCost = 0, disabilityInsCost = 0, retirementDeduction = 0;
     
	
	 
	do
	{
		skillLevel = JOptionPane.showInputDialog(null, "Enter your employee skill level (1 - 3).", "Skill Set Level", JOptionPane.QUESTION_MESSAGE);
		skillLevelInt = Integer.parseInt(skillLevel);
		
		if(skillLevelInt == 1 | skillLevelInt == 2 | skillLevelInt == 3)
			validSkillEntry = true;
		
	} while(!validSkillEntry);

   
   
    switch(skillLevelInt)
       {
       case(levelOne):
       hourlyPay = 17.00;
       insuranceOptionElig = false;
       retirementOptionElig = false;
       message = "";
       break;
      
       case(levelTwo):
       hourlyPay = 20.00;
       insuranceOptionElig = true;
       retirementOptionElig = false;
       message = "";
       break;
      
       case(levelThree):
       hourlyPay = 22.00;
       insuranceOptionElig = true;
       retirementOptionElig = true;
       message = "";
       break;
      
       default:
       {hourlyPay = 0;
       insuranceOptionElig = false;
       retirementOptionElig = false;
       message = "ERROR. You've entered an invalid skill level";
       System.out.println(message);
       System.exit(0);}
      
       }//closes skillLevel switch
	 
		hrsWorked = JOptionPane.showInputDialog(null, "Enter the number of hours you worked this week.", "Hours Worked", JOptionPane.QUESTION_MESSAGE);
		hrsWorkedDb = Double.parseDouble(hrsWorked);
	    
		//payment calculations
	    regular40Hrs = hourlyPay * hrsWorkedDb; //calculate reg $$amount for working 40hr 
	    if(hrsWorkedDb > 40)
	    {
	    	regular40Hrs = hourlyPay * 40;
	   	 	overtimeHrs = hrsWorkedDb - 40; //overtime hours worked
	    } else
	    overtimeHrs = 0;
	    overtimePay = overtimeHrs * 1.5; //calculate $$amount of additional (overtime) pay
   
   
	    totalPay = overtimePay + regular40Hrs; //total $$ pay

  	
    
	  //insurance eligbility and cost

	  
	  if(insuranceOptionElig)
      {
	  	medicalIns = JOptionPane.showConfirmDialog(null,"Do you want Medical Insurance?", "Medical Insurance", JOptionPane.YES_NO_OPTION);	
	
	  	if(medicalIns == JOptionPane.YES_OPTION)
         	medicalInsCost = 32.50;
      
     	 else
         	medicalInsCost = 0;        
     
		dentalIns = JOptionPane.showConfirmDialog(null,"Do you want Dental Insurance?", "Dental Insurance", JOptionPane.YES_NO_OPTION);

      
    	if(dentalIns == JOptionPane.YES_OPTION)
        	dentalInsCost = 20.00;
      
     	else
        	dentalInsCost = 0;
            
      	disabilityIns = JOptionPane.showConfirmDialog(null,"Would you like Disability Insurance?", "Disability Insurance", JOptionPane.YES_NO_OPTION);
          
      	if(disabilityIns == JOptionPane.YES_OPTION)
        	 disabilityInsCost = 20.00;
      
      	else
        	disabilityInsCost = 0;

     } //closes if statement for level 2 & 3 insurance options
	
       
	  
	  //retirement option
   
      if(retirementOptionElig)
         {
      	   	 retirementDeduct = JOptionPane.showConfirmDialog(null,"Would you to invest for your retirement?", "Retirement Witholding", JOptionPane.YES_NO_OPTION);      
			 if(retirementDeduct == JOptionPane.YES_OPTION)
				 retirementDeduction = 0.03 * totalPay;
 
         }//closes retirement option if statement
          
	
    
	 totalInsuranceDeduction = medicalInsCost + dentalInsCost + disabilityInsCost;
     totalDeductions = totalInsuranceDeduction + retirementDeduction; 
     totalPaycheck = totalPay - totalDeductions;
  
	 JOptionPane.showMessageDialog(null, "You worked " + hrsWorked + " hours this week." + "\nYour hourly pay rate is $" +  hourlyPay + "\nThe regular pay for working up to 40 hours is $" + regular40Hrs + "\nYour overtime pay is $" + overtimePay);
	 JOptionPane.showMessageDialog(null,"Your total (gross) pay before deductions is $" + totalPay);
	
	 if(totalDeductions > totalPay)
			 JOptionPane.showMessageDialog(null, "ERROR. Deductions cannot be greater than total earnings. Did you work enough hours this week?");
	 		 
	 else
	   {
		   JOptionPane.showMessageDialog(null, "Your medical insurance cost is $" + medicalInsCost + "\nYour dental insurance cost is $" + dentalInsCost + "\nYour disability insurance cost is $" + disabilityInsCost + "\nYour total insurance cost is $" + totalInsuranceDeduction + "\nYour retirement plan deduction is $" + retirementDeduction + "\nYour total deductions are $" + totalDeductions);
		   JOptionPane.showMessageDialog(null, "Your total paycheck after deductions is $" + totalPaycheck);
	   }
	}//closes main



}