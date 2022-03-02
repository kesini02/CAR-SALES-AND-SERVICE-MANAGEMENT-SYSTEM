package database;
public class Product2 {
   
private String car_modelNo;
    private String car_CarModel;
    
    private String car_CarBrand;
    private String car_CarColour;
    private String car_usedornewCar;
    private String car_Launchyear;
    private String car_Price ;
    private String car_fueltype;
   private byte[] car_image;
    
    public Product2(){}
    
    public Product2(String car_modelNo1, String car_CarModel1,String car_CarBrand1, String car_CarColour1,String car_usedornewCar1,String car_Launchyear1, String car_Price1 , String car_fueltype1,byte[] Mycar_image){
    
   this. car_modelNo= car_modelNo1;
   this.car_CarModel=car_CarModel1;
    
   this. car_CarBrand= car_CarBrand1;
   this. car_CarColour= car_CarColour1;
   this .car_usedornewCar=car_usedornewCar1;
   this .car_Launchyear=car_Launchyear1;
    this.car_Price=car_Price1 ;
   this.car_fueltype=car_fueltype1;
    this. car_image=Mycar_image;
       
    }

    
    
     public String getcar_modelNo1() {
        return car_modelNo;
    }
     
     public void setcar_modelNo1(String car_modelNo1){
        this.car_modelNo = car_modelNo1;
    }
    
   
    public String getcar_CarModel1()
    {
        return car_CarModel;
    }

   public void setcar_CarModel1(String car_CarModel1){
        this.car_CarModel = car_CarModel1;
    }
    
    public String getcar_CarBrand1() {
        return car_CarBrand;
    }
    public void setcar_CarBrand1(String car_CarBrand1){
        this.car_CarBrand = car_CarBrand1;
    }
    
    
     public String getcar_CarColour1() {
        return  car_CarColour;
    }
     public void setcar_CarColour1(String car_CarColour1){
        this.car_CarColour = car_CarColour1;
    }
   

    public String getcar_usedornewCar1() {
        return car_usedornewCar;
    }
    public void setcar_usedornewCar1(String car_usedornewCar1){
        this.car_usedornewCar = car_usedornewCar1;
    }

   
    
    public String getcar_Launchyear1() {
        return car_Launchyear;
    }

    public void setcar_Launchyear1(String car_Launchyear1){
        this.car_Launchyear = car_Launchyear1;
    }

    
     public String getcar_Price1() {
        return car_Price;
    }
     public void setcar_Price1(String car_Price1){
        this.car_Price = car_Price1;
    }
   
    
     public String getcar_fueltype1() {
        return car_fueltype;
    }

    public void setcar_fueltype1(String car_fueltype1){
        this.car_fueltype = car_fueltype1;
    }
    
    
   
    
   
   
    
    public byte[] getMycar_image(){
        return car_image;
    }
}


