import React from 'react';
import axios from 'axios';
import { useState, useEffect } from 'react';
import { BASE_PATH_DB } from '../utils/config';
import { Table } from 'antd';
import { Row, Col, InputNumber } from 'antd';
import { Button, Input, Modal, notification } from 'antd';
import { DeleteOutlined, EditOutlined, PlusCircleOutlined,
          SmileOutlined } from '@ant-design/icons';
import { Checkbox, Form } from 'antd';
import { createReward, updateReward, deleteReward } from '../services/reward_services';

const formItemLayout = {
  labelCol: {
    xs: {
      span: 24,
    },
    sm: {
      span: 8,
    },
  },
  wrapperCol: {
    xs: {
      span: 24,
    },
    sm: {
      span: 16,
    },
  },
};
const tailFormItemLayout = {
  wrapperCol: {
    xs: {
      span: 24,
      offset: 0,
    },
    sm: {
      span: 16,
      offset: 8,
    },
  },
};

const Reward = () => {

  const [rewards, setRewards] = useState([]);

  const [selectedRow, setSelectedRow] = useState([]);

  const [dataSearch, setDataSearch] = useState("");

  const [modalInsert, setModalInsert] = useState(false);

  const [modalUpdate, setModalUpdate] = useState(false);

  const [modalDelete, setModalDelete] = useState(false);

  const [disblableButton, setDisableButton] = useState(true);

  const [form] = Form.useForm();
  const [form2] = Form.useForm();

  const onFinish = (values) => {
    const updaterewardObject = {};

    updaterewardObject.nombre_pre = values.nombre;
    updaterewardObject.descripcion_pre = values.descripcion;
    updaterewardObject.puntos_rq_pre = values.puntos;
    createReward(updaterewardObject);
  //  window.location.reload();

    notification.success({
      message: 'Premio creado',
      description: `Se ha almacenado!`,
      icon: <SmileOutlined style={{ color: '#108ee9' }} />,});

  };

  const onFinishUpdate = (values) => {
    const updateRewardObject = {};

    updateRewardObject.nombre_pre = values.nombre;
    updateRewardObject.descripcion_pre = values.descripcion;
    updateRewardObject.puntos_rq_pre = values.puntos;
    console.log(updateRewardObject);
    updateReward(updateRewardObject,selectedRow.id_pre);

    notification.success({
      message: 'Premio actualizado',
      description: `Los datos han sido actualizados`,
      icon: <SmileOutlined style={{ color: '#108ee9' }} />,});
    //window.location.reload();
  };

  const resetValues = () => {
    setTimeout(form.resetFields(), 500);
    setTimeout(form2.resetFields(), 500);
  }

  const onSelectChange = (newSelectedRowKeys, data) => {
    setSelectedRow(data[0]);
    setDisableButton(false);
  };

  const rowSelection = {
    selectedRow,
    onChange: onSelectChange,
  };


  useEffect(() => {
    async function getAllRequest() {
      await axios.get(`${BASE_PATH_DB}/reward`)
        .then(response => {
          setRewards(response.data);
        })
    };
    getAllRequest();
  }, [])

  const sharedOnCell = (_, index) => {
    if (index === -1) {
      return {
        colSpan: 0,
      };
    }
    return {};
  };

  const columns = [
    {
      title: '#',
      dataIndex: `id_pre`,
      rowScope: 'id',
      defaultSortOrder: 'ascend',
      sorter: (a, b) => a.id_pre - b.id_pre,
    },
    {
      title: 'Nombre del Premio',
      dataIndex: 'nombre_pre',
      key: 'name',
      onCell: sharedOnCell,
      filteredValue: [dataSearch],
      onFilter: (value, record) => {
        return (
          String(record.nombre_pre)
            .toLowerCase()
            .includes(value.toLowerCase()) ||
          String(record.id_pre)
            .toLowerCase()
            .includes(value.toLowerCase()) ||
          String(record.puntos_rq_pre)
            .toLowerCase()
            .includes(value.toLowerCase())
        );
      }
    },
    {
      title: 'Descripción',
      dataIndex: 'descripcion_pre',
      key: 'description',
      onCell: sharedOnCell,
    },
    {
      title: 'Puntos Necesarios',
      dataIndex: 'puntos_rq_pre',
      key: 'points',
      onCell: sharedOnCell,
    },
  ];



  const { Search } = Input;

  return (
    <div>
      <Table columns={columns}
        dataSource={rewards}
        bordered
        rowKey={(record) => record.id_pre}
        rowSelection={{
          type: 'radio',
          ...rowSelection,
        }}
        title={() =>
          <Search
            placeholder="Ingrese #, nombre o puntos"
            allowClear
            enterButton="Buscar"
            size="large"
            onSearch={(value) => {
              setDataSearch(value);
            }}
          />}
        footer={() =>
          <Row>
            <Col span={8}></Col>
            <Col span={2}>
              <Button type="primary"
                style={{ background: '#3C86F1' }}
                icon={<PlusCircleOutlined />}
                onClick={() => {
                  resetValues();
                  setModalInsert(true);
                }} >
                Insertar
              </Button>
            </Col>
            <Col span={1}></Col>
            <Col span={2}>
              <Button
                type="primary"
                disabled={disblableButton}
                style={{ background: "#43EA35" }}
                icon={<EditOutlined />}
                onClick={() => {
                  resetValues();
                  setModalUpdate(true);
                }}>
                Actualizar
              </Button>
            </Col>
            <Col span={1}></Col>
            <Col span={2}>
              <Button
                type="primary"
                disabled={disblableButton}
                style={{ background: "#F14E4E" }}
                icon={<DeleteOutlined />}
                onClick={() => setModalDelete(true)}>
                Desactivar
              </Button>
            </Col>
            <Col span={8}></Col>
          </Row>} />

      <Modal
        title="Inserte un premio"
        centered
        open={modalInsert}
        onOk={() => setModalInsert(false)}
        onCancel={() => setModalInsert(false)}
      >
        <Form
          {...formItemLayout}
          form={form}
          name="register"
          onFinish={onFinish}
          style={{
            maxWidth: 600,
          }}
          scrollToFirstError
        >
          <Form.Item
            name="nombre"
            label="Nombre"
            rules={[
              {
                type: 'string',
                message: 'Ingrese un nombre valido!',
              },
              {
                required: true,
                message: 'Ingrese un nombre!',
              },
            ]}
          >
            <Input />
          </Form.Item>

          <Form.Item
            name="descripcion"
            label="Descripcion"
            rules={[
              {
                type: 'string',
                message: 'Ingrese una descripcion valida!',
              },
              {
                required: true,
                message: 'Ingrese una descripcion!',
              },
            ]}
          >
            <Input />
          </Form.Item>

      

          <Form.Item
            name="puntos"
            label="Puntos"
            rules={[
              {
                required: true,
                message: 'Ingrrese una cantidad de puntos(50-10000)!',
              },
            ]}
          >
          <InputNumber min={50} max={10000} defaultValue={50} />
          </Form.Item>

          <Form.Item
            name="terminos"
            valuePropName="checked"
            rules={[
              {
                validator: (_, value) =>
                  value ? Promise.resolve() : Promise.reject(new Error('Debe aceptar')),
              },
            ]}
            {...tailFormItemLayout}
          >
            <Checkbox>
              Acepto los <a>terminos y condiciones </a>
            </Checkbox>
          </Form.Item>
          <Form.Item {...tailFormItemLayout}>
            <Button type="primary" htmlType="submit">
              Ingresar
            </Button>
          </Form.Item>
        </Form>
      </Modal>

      <Modal
        title="Editar"
        centered
        open={modalUpdate}
        onCancel={() => {
          setModalUpdate(false);
          resetValues();
        }}
        onOk={() => {
          setModalUpdate(false);
          resetValues();
        }}
      >
        <Form
          {...formItemLayout}
          form={form2}
          name="update"
          onFinish={onFinishUpdate}
          style={{
            maxWidth: 600,
          }}
          scrollToFirstError
        >
        <Form.Item
            name="nombre"
            label="Nombre"
            initialValue={selectedRow.nombre_pre}
            rules={[
              {
                type: 'string',
                message: 'Ingrese un nombre valido!',
              },
              {
                required: true,
                message: 'Ingrese un nombre!',
              },
            ]}
          >
            <Input />
          </Form.Item>

          <Form.Item
            name="descripcion"
            label="Descripcion"
            initialValue={selectedRow.descripcion_pre}
            rules={[
              {
                type: 'string',
                message: 'Ingrese una descripcion valida!',
              },
              {
                required: true,
                message: 'Ingrese una descripcion!',
              },
            ]}
          >
            <Input />
          </Form.Item>

      

          <Form.Item
            name="puntos"
            label="Puntos"
            initialValue={selectedRow.puntos_rq_pre}
            rules={[
              {
                required: true,
                message: 'Ingrrese una cantidad de puntos(50-10000)!',
              },
            ]}
          >
          <InputNumber min={50} max={10000} defaultValue={50} />
          </Form.Item>

          <Form.Item {...tailFormItemLayout}>
            <Button type="primary" htmlType="submit">
              Actualizar
            </Button>
          </Form.Item>
        </Form>
      </Modal>

      <Modal
        title="Desactivar premio"
        centered
        open={modalDelete}
        okButtonProps={{danger:true}}
        onOk={() => {
          deleteReward(selectedRow.id_pre);
          setModalDelete(false);
          notification.warning({
            message: 'Premio eliminado',
            description: `Los datos han sido eliminados`,});
        }}
        onCancel={() => setModalDelete(false)}
      >
        <p>Esta a punto de desactivar el premio
            {` ${selectedRow.nombre_pre} `} 
            con ID: {selectedRow.id_pre} </p>

      </Modal>

    </div>
  );
};

export default Reward;