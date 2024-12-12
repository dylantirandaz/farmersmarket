@RestController
@RequestMapping("/api/markets")
public class FarmersMarketController {

    private final FarmersMarketService service;

    public FarmersMarketController(FarmersMarketService service) {
        this.service = service;
    }

    @GetMapping
    public List<FarmersMarket> getAllMarkets() {
        return service.getAllMarkets();
    }

    @GetMapping("/day/{day}")
    public List<FarmersMarket> getMarketsByDay(@PathVariable String day) {
        return service.getMarketsByDay(day);
    }

    @GetMapping("/vendor/{vendorType}")
    public List<FarmersMarket> getMarketsByVendorType(@PathVariable String vendorType) {
        return service.getMarketsByVendorType(vendorType);
    }
}
