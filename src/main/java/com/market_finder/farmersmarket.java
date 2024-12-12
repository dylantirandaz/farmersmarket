@Entity
public class FarmersMarket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String location;
    private String hours;
    private String dayOfWeek;
    private String vendorTypes;
    private boolean specialEvent;

//i need to add get and set methods... <construction>
}
