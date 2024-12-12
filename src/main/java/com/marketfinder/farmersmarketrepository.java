public interface FarmersMarketRepository extends JpaRepository<FarmersMarket, Long> {
    List<FarmersMarket> findByDayOfWeek(String dayOfWeek);
    List<FarmersMarket> findByVendorTypesContaining(String vendorType);
}
