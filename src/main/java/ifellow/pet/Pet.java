package ifellow.pet;

import lombok.Data;

import java.util.ArrayList;

@Data
public class Pet {

    public long id;
    public Category category;
    public String name;
    public ArrayList<String> photoUrls;
    public ArrayList<Tag> tags;
    public String status;
}
