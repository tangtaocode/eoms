package eoms.cn.repository.entity;

import javax.persistence.Id;
import javax.persistence.Table;

@Table(name="p_everyday_everyseat_achievement")
public class EverydayEeveryseatAchievement {
    @Id
    private Long id;

    private Long projectId;

    private Long productId;

    private String dynamic1;

    private String dynamic2;

    private String dynamicn;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getDynamic1() {
        return dynamic1;
    }

    public void setDynamic1(String dynamic1) {
        this.dynamic1 = dynamic1;
    }

    public String getDynamic2() {
        return dynamic2;
    }

    public void setDynamic2(String dynamic2) {
        this.dynamic2 = dynamic2;
    }

    public String getDynamicn() {
        return dynamicn;
    }

    public void setDynamicn(String dynamicn) {
        this.dynamicn = dynamicn;
    }
}