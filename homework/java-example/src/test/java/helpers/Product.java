package helpers;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.*;

import static helpers.RandomHelper.*;

public class Product {

    Random rnd = new Random();

    private boolean enabled;
    private String code;
    private String name;
    private String category;
    private String productGroup;
    private int quantity;
    private String unit;
    private String deliveryStatus;
    private String soldOutStatus;
    private Calendar validFrom;
    private Calendar validTo;
    private String manufacturer;
    private String supplier;
    private List<String> keyWords;
    private String shortDescription;
    private String description;
    private String headTitle;
    private String metaDescription;
    private String price;
    private String currency;

    public boolean isEnabled() {
        return enabled;
    }

    public Product setEnabled() {
        this.enabled = true;
        return this;
    }

    public Product setDisabled() {
        this.enabled = false;
        return this;
    }

    public String getCode() {
        return code;
    }

    public Product setCode(String code) {
        this.code = code;
        return this;
    }

    public Product setRandomCode(){
        setCode(getNumericLineWithLength(10));
        return this;
    }

    public String getName() {
        return name;
    }

    public Product setName(String name) {
        this.name = name;
        return this;
    }

    public Product setRandomName(){
        setName(getLettersLineWithLength(10));

        return this;
    }

    public String getCategory() {
        return category;
    }

    public Product setCategory(String category) {
        this.category = category;
        return this;
    }

    public String getProductGroup() {
        return productGroup;
    }

    public Product setProductGroup(String productGroup) {
        this.productGroup = productGroup;
        return this;
    }

    public Product setGroupMale(){
        setProductGroup(Litecart.PRODUCT_GROUP_MALE);
        return this;
    }

    public Product setGroupFemale(){
        setProductGroup(Litecart.PRODUCT_GROUP_FEMALE);
        return this;
    }

    public Product setGroupUnisex(){
        setProductGroup(Litecart.PRODUCT_GROUP_UNISEX);
        return this;
    }

    public Product setRandomProductGroup(){
        int choise = rnd.nextInt(3);
        switch(choise){
            case 0: setGroupMale();return this;
            case 1: setGroupFemale();return this;
            case 2: setGroupUnisex();return this;
            default: setGroupUnisex();
        }
        return this;
    }

    public int getQuantity() {
        return quantity;
    }

    public Product setQuantity(int quantity) {
        this.quantity = quantity;
        return this;
    }

    public Product setRandomQuantity() {
        this.quantity = rnd.nextInt(1000);
        return this;
    }

    public String getUnit() {
        return unit;
    }

    public Product setUnit(String unit) {
        this.unit = unit;
        return this;
    }

    public String getDeliveryStatus() {
        return deliveryStatus;
    }

    public Product setDeliveryStatus(String deliveryStatus) {
        this.deliveryStatus = deliveryStatus;
        return this;
    }

    public String getSoldOutStatus() {
        return soldOutStatus;
    }

    public Product setSoldOutStatus(String soldOutStatus) {
        this.soldOutStatus = soldOutStatus;
        return this;
    }

    public Calendar getValidFrom() {
        return validFrom;
    }

    public Product setValidFrom(Calendar validFrom) {
        this.validFrom = validFrom;
        return this;
    }

    public Product setValidFromToday(){
        Calendar cal = Calendar.getInstance();
        setValidFrom(cal);
        return this;
    }

    public Calendar getValidTo() {
        return validTo;
    }

    public Product setValidTo(Calendar validTo) {
        this.validTo = validTo;
        return this;
    }

    public Product setRandomValidTo() {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DAY_OF_YEAR, rnd.nextInt(100));
        setValidTo(cal);
        return this;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public Product setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
        return this;
    }

    public String getSupplier() {
        return supplier;
    }

    public Product setSupplier(String supplier) {
        this.supplier = supplier;
        return this;
    }

    public List<String> getKeyWords() {
        return keyWords;
    }

    public Product setKeyWords(List<String> keyWords) {
        this.keyWords = keyWords;
        return this;
    }

    public Product setRandomKeywords(){
        int quantity = rnd.nextInt(10)+1;
        List<String> keyWords = new ArrayList<String>();
        for(int i = 0; i<quantity; i++){
            keyWords.add(getLettersLineWithLength(5));
        }
        setKeyWords(keyWords);
        return this;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public Product setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
        return this;
    }

    public Product setRandomShortDescription(){
        int quantity = rnd.nextInt(5)+1;
        String shortDescription = "";
        for(int i = 0; i<quantity; i++){
            shortDescription = shortDescription + " " + getLettersLineWithLength(5);
        }
        setShortDescription(shortDescription);
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Product setDescription(String description) {
        this.description = description;
        return this;
    }

    public Product setRandomDescription(){
        int quantity = rnd.nextInt(50)+1;
        String description = "";
        for(int i = 0; i<quantity; i++){
            description = description + " " + getLettersLineWithLength(5);
        }
        setDescription(description);
        return this;
    }

    public String getHeadTitle() {
        return headTitle;
    }

    public Product setHeadTitle(String headTitle) {
        this.headTitle = headTitle;
        return this;
    }

    public Product setRandomHeadTitle(){
        setHeadTitle(getLettersLineWithLength(5)+" "+getLettersLineWithLength(10));
        return this;
    }

    public String getMetaDescription() {
        return metaDescription;
    }

    public Product setMetaDescription(String metaDescription) {
        this.metaDescription = metaDescription;
        return this;
    }

    public Product setRandomMetaDescription(){
        setMetaDescription(getLettersLineWithLength(5)+" "+getLettersLineWithLength(10)+ " " + getNumericLineWithLength(6));
        return this;
    }

    public String getPrice() {
        return price;
    }

    public Product setPrice(String price) {
        this.price = price;
        return this;
    }

    public Product setRandomPrice(){
        setPrice(rnd.nextInt(100)+"");
        return this;
    }

    public String getCurrency() {
        return currency;
    }

    public Product setCurrency(String currency) {
        this.currency = currency;
        return this;
    }

    public Product setCurrencyEur(){
        setCurrency(Litecart.CURRENCY_EUR);
        return this;
    }

    public Product setCurrencyUsd(){
        setCurrency(Litecart.CURRENCY_USD);
        return this;
    }

    public Product setRandomCurrency(){
        int choise = new Random().nextInt(2);
        switch(choise){
            case 0: setCurrencyEur();return this;
            case 1: setCurrencyUsd();return this;
            default: setCurrencyUsd();
        }
        return this;
    }


}