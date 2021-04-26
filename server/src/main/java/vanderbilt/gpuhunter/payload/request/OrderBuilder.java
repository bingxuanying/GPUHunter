package vanderbilt.gpuhunter.payload.request;


import com.fasterxml.jackson.annotation.JsonProperty;
import vanderbilt.gpuhunter.wroker.Order;

import javax.validation.constraints.NotBlank;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class OrderBuilder {

    @NotBlank
    private String username;

    @NotBlank
    private String password;

    @NotBlank
    private List<String> proxyLst;

    @NotBlank
    private List<Boolean> selectedGPU;

    private List<Integer> targetPrice;

    private Integer refreshRate;

    private Integer timestamp;

    private Integer scheduledTime;

    public OrderBuilder(@JsonProperty("username") String username,
                        @JsonProperty("password") String password,
                        @JsonProperty("proxyLst") List<String> proxyLst,
                        @JsonProperty("selectedGPU")List<Boolean> selectedGPU,
                        @JsonProperty("targetPrice")List<Integer> targetPrice,
                        @JsonProperty("refreshRate")Integer refreshRate,
                        @JsonProperty("timestamp")Integer timestamp,
                        @JsonProperty("scheduledTime")Integer scheduledTime) {
        this.username = username;
        this.password = password;
        this.proxyLst = proxyLst;
        this.selectedGPU = selectedGPU;
        this.targetPrice = targetPrice;
        this.refreshRate = refreshRate;
        this.timestamp = timestamp == null ? getCurrentTime() : timestamp;
        this.scheduledTime = scheduledTime < getCurrentTime() ? null : scheduledTime;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public List<String> getProxyLst() {
        return proxyLst;
    }

    public List<Boolean> getSelectedGPU() {
        return selectedGPU;
    }

    public List<Integer> getTargetPrice() {
        return targetPrice;
    }

    public Integer getRefreshRate() {
        return refreshRate;
    }

    public Integer getTimestamp() {
        return timestamp;
    }

    public Integer getScheduledTime() {
        return scheduledTime;
    }

    private Integer getCurrentTime() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
        return Integer.parseInt(formatter.format(new Date()));
    }

    public Order build() {
        Order order = new Order(this);
        validateOrderObject(order);
        return order;
    }

    private void validateOrderObject(Order order) {
        validateUsernamePassword(order.getUsername(), order.getPassword());
        validateProxyFormat(order.getProxyLst());
        validateScheduledTimeFormat(order.getScheduledTime());
        validateGPUSelected(order.getSelectedGPU());
    }

    // Attempt to log into corresponding websites
    private void validateUsernamePassword(String username, String password) {
    }

    // Validate proxy link
    private void validateProxyFormat(List<String> proxyLst) {
    }

    // Validate schedule time format
    private void validateScheduledTimeFormat(Integer timestamp) {
    }

    // Make sure has gpu selected
    private void validateGPUSelected(List<Boolean> selectedGPU) {
        if (!selectedGPU.stream().anyMatch(item -> item == true)) {
            throw new IllegalArgumentException("Have to select at least one gpu.");
        }
    }
}
