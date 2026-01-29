//Base Class: WebElement
class WebElement {
 public void click() {
     System.out.println("WebElement.click()-click action");
 }
 
 public void setText(String text) {
     System.out.println("WebElement.setText()-Entered: "+text);
 }
}

//Subclass 1: Button (inherits WebElement)
class Button extends WebElement {
 public void submit() {
     System.out.println("Button.submit()-submitted successfully!");
 }
}

//Subclass 2: TextField (inherits WebElement)  
class TextField extends WebElement {
 public void getText() {
     System.out.println("TextField.getText()-Retrieved text from field");
 }
}

//Subclass 3: CheckBoxButton (inherits Button → WebElement)
class CheckBoxButton extends Button {
 public void clickCheckButton() {
     System.out.println("CheckBoxButton.clickCheckButton()-Checkbox Selected!");
 }
}

//Subclass 4: RadioButton (inherits Button → WebElement)
class RadioButton extends Button {
 public void selectRadioButton() {
     System.out.println("RadioButton.selectRadioButton()-Radio option selected!");
 }
}

//Execution Class: Elements (inherits Button for demo)
class Elements extends Button {
 public static void main(String[] args) {
     
	 System.out.println("=== WebElement Hierarchy Demo ===\n");
     // 1. TextField Demo (inherits WebElement)
     System.out.println("TEXTFIELD:");
     TextField textField = new TextField();
     textField.click();
     textField.setText("Test");
     textField.getText();
     System.out.println();
     
     // 2. Button Demo (inherits WebElement) 
     System.out.println("BUTTON:");
     Button button = new Button();
     button.click();
     button.submit();
     System.out.println();
     
     // 3. CheckBoxButton Demo (Button → WebElement)
     System.out.println("CHECKBOXBUTTON:");
     CheckBoxButton checkBox = new CheckBoxButton();
     checkBox.click();
     checkBox.submit();
     checkBox.clickCheckButton();
     System.out.println();
     
     // 4. RadioButton Demo (Button → WebElement)
     System.out.println("RADIOBUTTON:");
     RadioButton radio = new RadioButton();
     radio.click();
     radio.submit();
     radio.selectRadioButton();
 }
}

