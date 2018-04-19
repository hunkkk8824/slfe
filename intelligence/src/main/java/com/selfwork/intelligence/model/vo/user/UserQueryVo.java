package com.selfwork.intelligence.model.vo.user;

import com.selfwork.intelligence.model.po.UserInfoPO;
import com.selfwork.intelligence.model.vo.BaseQueryVo;

public class UserQueryVo extends BaseQueryVo {
    /**
     * 关键字
     */
    private String keyword;

    /**
     * 状态
     */
    private Boolean valid;

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public Boolean getValid() {
        return valid;
    }

    public void setValid(Boolean valid) {
        this.valid = valid;
    }

    
}
