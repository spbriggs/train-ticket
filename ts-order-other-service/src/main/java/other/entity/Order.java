package other.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;


import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

/**
 * @author fdse
 */
@Data
@Table(name = "orderOther")
@Entity
@GenericGenerator(name = "jpa-uuid",strategy="uuid")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Order {
    //orders
    @Id
    @Column(name = "orderId")
//    @GeneratedValue(generator = "jpa-uuid")
    private String id;

    private Date boughtDate;

    @Column(name = "startingTime")
    private Date travelDate;

    private Date travelTime;

    /**
     * Which Account Bought it
     */
//    @GeneratedValue(generator = "jpa-uuid")
    @Column(name = "userId")
    private String accountId;

    /**
     * Tickets bought for whom
     */
    private String contactsName;

    @Column(name = "contactsDocumentType")
    private int documentType;

    private String contactsDocumentNumber;

    @Column(name = "trainTypeId")
    private String trainNumber;

    private int coachNumber;

    private int seatClass;

    private String seatNumber;

    @Column(name = "orderStartingStationId")
    private String from;

    @Column(name = "orderTerminalStationId")
    private String to;

    private int status;

    @Column(name = "orderPrice")
    private String price;

    public Order(){
        boughtDate = new Date(System.currentTimeMillis());
        travelDate = new Date(123456789);
        trainNumber = "G1235";
        coachNumber = 5;
        seatClass = SeatClass.FIRSTCLASS.getCode();
        seatNumber = "1";
        from = "shanghai";
        to = "taiyuan";
        status = OrderStatus.PAID.getCode();
        price = "0.0";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Order other = (Order) obj;
        return boughtDate.equals(other.getBoughtDate())
                && travelDate.equals(other.getTravelDate())
                && travelTime.equals(other.getTravelTime())
                && accountId .equals( other.getAccountId() )
                && contactsName.equals(other.getContactsName())
                && contactsDocumentNumber.equals(other.getContactsDocumentNumber())
                && documentType == other.getDocumentType()
                && trainNumber.equals(other.getTrainNumber())
                && coachNumber == other.getCoachNumber()
                && seatClass == other.getSeatClass()
                && seatNumber .equals(other.getSeatNumber())
                && from.equals(other.getFrom())
                && to.equals(other.getTo())
                && status == other.getStatus()
                && price.equals(other.price);
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + (id == null ? 0 : id.hashCode());
        return result;
    }

    public void setTravelDate(int year,int month,int day){
        Date date = new Date(year,month,day,0,0,0); //NOSONAR
        this.travelDate = date;
    }

}
