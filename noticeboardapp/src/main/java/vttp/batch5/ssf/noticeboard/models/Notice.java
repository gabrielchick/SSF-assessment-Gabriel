package vttp.batch5.ssf.noticeboard.models;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class Notice {
    
    @NotBlank(message = "title is mandatory")
    @Size(min = 3, max = 128, message = "title must be between 3 and 128 characters")
    private String title;

    @NotBlank(message = "email is mandatory")
    @Email(message = "use a valid email format")
    private String poster;

    @NotBlank(message = "date is mandatory")
    @FutureOrPresent(message = "please only select a date from today or the future")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date date;

    @NotBlank(message = "category is mandatory")
    @Size(min = 1, message = "select at least 1 category")
    private String categories;

    @NotBlank(message = "message is mandatory")
    private String text;

    public Notice(String title, String poster, Date date, String categories, String text) {
        this.title = title;
        this.poster = poster;
        this.date = date;
        this.categories = categories;
        this.text = text;
    }

    public Notice() {

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getCategories() {
        return categories;
    }

    public void setCategories(String categories) {
        this.categories = categories;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }    
    
    @Override
    public String toString() {
        return  title + "," + poster + "," + date + "," + categories + "," + text;
    }
}
