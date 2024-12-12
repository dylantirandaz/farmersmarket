@Service
public class FarmersMarketService {

    private final FarmersMarketRepository repository;

    public FarmersMarketService(FarmersMarketRepository repository) {
        this.repository = repository;
    }

    public List<FarmersMarket> getAllMarkets() {
        return repository.findAll();
    }

    public List<FarmersMarket> getMarketsByDay(String day) {
        return repository.findByDayOfWeek(day);
    }

    public List<FarmersMarket> getMarketsByVendorType(String vendorType) {
        return repository.findByVendorTypesContaining(vendorType);
    }
}
