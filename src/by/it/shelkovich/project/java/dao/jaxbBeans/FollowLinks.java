package by.it.shelkovich.project.java.dao.jaxbBeans;

import by.it.shelkovich.project.java.dao.entities.FollowLink;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "followLinks"
})
@XmlRootElement(name="Follow_Links")
public class FollowLinks {
    @XmlElement(required = true, name="Follow_link")
    List<FollowLink> followLinks;

    public FollowLinks() {
    }

    public FollowLinks(List<FollowLink> followLinks) {
        this.followLinks = followLinks;
    }

    public List<FollowLink> getFollowLinks() {
        return followLinks;
    }

    public void setFollowLinks(List<FollowLink> followLinks) {
        this.followLinks = followLinks;
    }
}
