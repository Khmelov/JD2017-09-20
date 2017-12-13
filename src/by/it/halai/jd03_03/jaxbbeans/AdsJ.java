package by.it.halai.jd03_03.jaxbbeans;

import by.it.halai.jd03_02.beans.Ad;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "AdsJ"
})
@XmlRootElement(name = "AdsJ")
public class AdsJ {

    @XmlElement(name = "Ads", required = true)
    List<Ad> AdsJ = new ArrayList<>();

    public AdsJ() {
    }

    public AdsJ(List<Ad> AdsJ) {
        this.AdsJ = AdsJ;
    }

    public List<Ad> getAdsJ() {
        return AdsJ;
    }

    public void setAdsJ(List<Ad> AdsJ) {
        this.AdsJ = AdsJ;
    }
}

