package vanderbilt.gpuhunter.wroker;

import vanderbilt.gpuhunter.payload.request.OrderBuilder;

import java.util.List;

public class Order {

    private String username;

    private String password;

    private List<String> proxyLst;

    private List<Boolean> selectedGPU;

    private List<Integer> targetPrice;

    private Integer refreshRate;

    private Integer timestamp;

    private Integer scheduledTime;

    public Order(OrderBuilder builder) {
        this.username = builder.getUsername();
        this.username = builder.getPassword();
        this.proxyLst = builder.getProxyLst();
        this.selectedGPU = builder.getSelectedGPU();
        this.targetPrice = builder.getTargetPrice();
        this.refreshRate = builder.getRefreshRate();
        this.timestamp = builder.getTimestamp();
        this.scheduledTime = builder.getScheduledTime();
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
}
