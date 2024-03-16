import React from "react";
import { Layout, Menu } from "antd";
import items from "../utils/items";
import { useState } from 'react';

const Sider = () => {

    const [collapsed, setCollapsed] = useState(false);

return(
    <Layout.Sider collapsible collapsed={collapsed} onCollapse={(value) => setCollapsed(value)}>
        <div className="demo-logo-vertical" />
        <Menu theme="dark" defaultSelectedKeys={['1']} mode="inline" items={items} />
    </Layout.Sider>
);
}

export default Sider;