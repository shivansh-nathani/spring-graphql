package com.example.demo.types;

public class BookType {

    private String id;
    private String name;
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public BookType(String id, String name) {
        super();
        this.id = id;
        this.name = name;
    }
    public BookType()
    {
    	
    }


}
