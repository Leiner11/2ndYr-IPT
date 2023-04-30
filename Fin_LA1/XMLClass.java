package fin_LA1;

public class XMLClass {

	    private String Subcode;
	    private String Units;
	    private String Description;
	    private String Category;
	    private Integer Number;
	    
	    public XMLClass(Integer Number, String Subcode, String Units, String Description, 
	    		String Category) {
	        this.Subcode = Subcode;
	        this.Units = Units;
	        this.Description = Description;
	        this.Category = Category;
	        this.Number = Number;
	    }
	    
	    public String getSubcode() {
	        return Subcode;
	    }
	    
	    public void setSubcode(String Subcode) {
	        this.Subcode = Subcode;
	    }
	    
	    public String getUnits() {
	        return Units;
	    }
	    
	    public void setUnits(String Units) {
	        this.Units = Units;
	    }
	    
	    public String getDescription() {
	        return Description;
	    }
	    
	    public void setDescription(String Description) {
	        this.Description = Description;
	    }
	    
	    public String getCategory() {
	        return Category;
	    }
	    
	    public void setCategory(String Category) {
	        this.Category = Category;
	    }
	    
	    public void setNumber(Integer Number) {
	        this.Number = Number;
	    }
	    public Integer getNumber() {
	        return Number;
	    }
	    
	    public String toString() {
	        return  "\n\n" + "No.:" + Number + "\n" + 
	        		"Subject Information:" + "\n" + 
	        		"SubCode: " + Subcode + "\n" +
	        		"Description: " + Description + "\n" + 
	        		"Units: " + Units + "\n" + 
	        		"Category: " + Category;
	        
	    }
	}