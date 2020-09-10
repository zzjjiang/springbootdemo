package com.jone.controller.vo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @description
 *  tree组件
 */
public class TreeVO implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 节点唯一索引值，用于对指定节点进行各类操作
     */
    private String id;
    /**
     * 节点标题
     */
    private String title;
    /**
     * 子节点。支持设定选项同父节点
     */
    private List<TreeVO> children = new ArrayList<>();

    /**
     * 父ID
     */
    private String parentId;

    /**
     * 左侧菜单图表
     */
    private String icon;

    /**
     * 跳转链接
     */
    private String href;

    /**
     * 跳转方式 0 Tab方式展开 1 新页面展开
     */
    private int isTab;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<TreeVO> getChildren() {
        return children;
    }

    public void setChildren(List<TreeVO> children) {
        this.children = children;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public int getIsTab() {
        return isTab;
    }

    public void setIsTab(int isTab) {
        this.isTab = isTab;
    }
}
