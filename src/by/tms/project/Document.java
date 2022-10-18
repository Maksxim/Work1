package by.tms.project;

public class Document {

    private String document_number;
    private String create_date;
    private String other_information;

    public Document(String document_number, String create_date, String other_information) {
        this.document_number = document_number;
        this.create_date = create_date;
        this.other_information = other_information;
    }

    @Override
    public String toString() {
        return "Document{" +
                "document_number='" + document_number + '\'' +
                ", create_date='" + create_date + '\'' +
                ", other_information='" + other_information + '\'' +
                '}';
    }
}
