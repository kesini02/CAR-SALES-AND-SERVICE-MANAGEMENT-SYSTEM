package database;
public class datas {
    private String BookingId;
    private String RegistrationName;
    private String CarModelNo;
    private String CarBrand;
    private String DeliveryDate;
    private String PancardNo;
    private String Accessories;
    private String PaymentMethod;
    private String AadhaarNumber;
    private String Occupation;
    private String Phoneno;
    
     
    public String getPhoneno(){
       return Phoneno;
   }
   
   public void setPhoneno(String Phoneno) {
        this.Phoneno= Phoneno;
    }
    
   public String getBookingId(){
       return BookingId;
   }
   
   public void setBookingId(String BookingId) {
        this.BookingId = BookingId;
    }
   
   public String getRegistrationName() {
        return RegistrationName;
    } 
   
   public void setRegistrationName(String RegistrationName) {
        this.RegistrationName = RegistrationName;
   }

    public String getCarModelNo() {
        return CarModelNo;
    }

    public void setCarModelNo(String CarModelNo) {
        this.CarModelNo = CarModelNo;
    }

    public String getCarBrand() {
        return CarBrand;
    }

    public void setCarBrand(String CarBrand) {
        this.CarBrand = CarBrand;
    }

    public String getDeliveryDate() {
        return DeliveryDate;
    }

    public void setDeliveryDate(String DeliveryDate) {
        this.DeliveryDate = DeliveryDate;
    }
    
    public String getPancardNo(){
       return PancardNo;
   }
   
   public void setPancardNo(String PancardNo) {
        this.PancardNo = PancardNo;
    }
   
   public String getAccessories() {
        return Accessories;
    } 
   
   public void setAccessories(String Accessories) {
        this.Accessories = Accessories;
   }

    public String getPaymentMethod() {
        return PaymentMethod;
    }

    public void setPaymentMethod(String PaymentMethod) {
        this.PaymentMethod =PaymentMethod;
    }

    public String getAadhaarNumber() {
        return AadhaarNumber;
    }

    public void setAadhaarNumber(String adhaarNumber) {
        this.AadhaarNumber = AadhaarNumber;
    }

    public String getOccupation() {
        return Occupation;
    }

    public void setOccupation(String Occupation) {
        this.Occupation = Occupation;
    }
}
 