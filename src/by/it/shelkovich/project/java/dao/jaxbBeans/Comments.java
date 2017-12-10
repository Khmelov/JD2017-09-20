package by.it.shelkovich.project.java.dao.jaxbBeans;

import by.it.shelkovich.project.java.dao.entities.Comment;
import by.it.shelkovich.project.java.dao.entities.User;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "comments"
})
@XmlRootElement(name="Comments")
public class Comments {
    @XmlElement(required = true, name="Comment")
    List<Comment> comments;

    public Comments() {
    }

    public Comments(List<Comment> comments) {
        this.comments = comments;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }
}
