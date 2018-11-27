package com.allen;

class Person{
    private String sNumber;
	private String name;
	private String phone ;
	private String gender;
	
	public Person (String n, String sn, String p, String g){
        phone = phoneFormat(p);
        name = n.toUpperCase();
        sNumber = staffValid(sn);
		gender = g;
    }

    public String phoneFormat(String phone){

        if(phone.length()==9){

            String x = phone.substring(0,2);
            String y = phone.substring(2,9);
            phone = "(" + x + ")" + y;

        }else if(phone.length()==10){

            String x = phone.substring(0,3);
            String y = phone.substring(3,10); 
            phone = "(" + x + ")" + y;

     }else{

         phone = "invalid";

     }

     return phone;

    }


    public String staffValid (String num){

          sNumber = num;

        for(int x = 0; x<sNumber.length(); x++){
            char c = sNumber.charAt(x);
            if(c>48 && c <57 ){              

        }else{
           sNumber = "Invalid";

        }

        
    }
        return sNumber;
   }



    public String getNumber(){return sNumber;}
	public String getName(){return name;}
	public String getPhone(){return phone;}
	public String getGender(){return gender;}
	
	public String toString(){
        return (name +""+ sNumber +" " + phone +" "+ gender);
        
    }
    
    
}