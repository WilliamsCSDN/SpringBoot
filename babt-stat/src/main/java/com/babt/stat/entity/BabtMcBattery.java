package com.babt.stat.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

import java.io.Serializable;

@TableName("babt_mc_battery")
public class BabtMcBattery extends Model<BabtMcBattery> {
    @TableId(value = "ID",type= IdType.AUTO)
    private int id;

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
