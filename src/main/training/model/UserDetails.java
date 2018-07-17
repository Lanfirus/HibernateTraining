package training.model;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table (name = "USER_DETAILS")
public class UserDetails {

    @Id
    @GeneratedValue
    private int userId;
    private String userName;
    @Temporal(TemporalType.DATE)
    private Date joinedDate;
    private String description;
    @ElementCollection
    private Set<Address> listOfAddresses = new HashSet<>();

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    //@Column (name = "USER_NAME")
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Date getJoinedDate() {
        return joinedDate;
    }

    public void setJoinedDate(Date joinedDate) {
        this.joinedDate = joinedDate;
    }

    @Lob
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<Address> getListOfAddresses() {
        return listOfAddresses;
    }

    public void setListOfAddresses(Set<Address> listOfAddresses) {
        this.listOfAddresses = listOfAddresses;
    }
}