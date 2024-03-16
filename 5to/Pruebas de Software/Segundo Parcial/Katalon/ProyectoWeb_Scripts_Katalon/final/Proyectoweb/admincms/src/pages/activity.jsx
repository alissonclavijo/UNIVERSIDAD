import React from 'react';
import axios from 'axios';
import { useState, useEffect } from 'react';
import { BASE_PATH_DB } from '../utils/config';
import { Table, TimePicker } from 'antd';
import { Row, Col } from 'antd';
import { Button, Input, Modal, notification } from 'antd';
import {
  DeleteOutlined, EditOutlined, PlusCircleOutlined,
  SmileOutlined
} from '@ant-design/icons';
import { Checkbox, Form, Select, DatePicker, InputNumber } from 'antd';
import { createactivity, updateactivity, deleteactivity } from '../services/activity_services';
import dayjs from 'dayjs';
const { Option } = Select;

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

const Activity = () => {

  const [activitys, setactivitys] = useState([]);

  const [selectedRow, setSelectedRow] = useState([]);

  const [dataSearch, setDataSearch] = useState("");

  const [modalInsert, setModalInsert] = useState(false);

  const [modalUpdate, setModalUpdate] = useState(false);

  const [modalDelete, setModalDelete] = useState(false);

  const [disblableButton, setDisableButton] = useState(true);

  const [form] = Form.useForm();
  const [form2] = Form.useForm();

  const onFinish = (values) => {
    const updateactivityObject = {};
    const month = values.nacimiento.$M + 1;

    updateactivityObject.nombre_activity = values.nombre;
    updateactivityObject.apellido_activity = values.apellido;
    updateactivityObject.correo_activity = values.correo;
    updateactivityObject.contrasena_activity = `${values.apellido}${values.nacimiento.$y}`;
    updateactivityObject.fecha_nacimiento_activity = `${values.nacimiento.$y}-${month}-${values.nacimiento.$D}`;
    updateactivityObject.genero_activity = values.genero;
    updateactivityObject.id_emp = 1;
    updateactivityObject.id_admin = 1;

    createactivity(updateactivityObject);

    notification.success({
      message: 'Usuario creado',
      description: `Notifique al usuario`,
      icon: <SmileOutlined style={{ color: '#108ee9' }} />,
    });

  };

  const onFinishUpdate = (values) => {
    const updateactivityObject = {};
    const month = values.nacimiento.$M + 1;

    updateactivityObject.nombre_activity = values.nombre;
    updateactivityObject.apellido_activity = values.apellido;
    updateactivityObject.correo_activity = values.correo;
    updateactivityObject.contrasena_activity = `${values.apellido}${values.nacimiento.$y}`;
    updateactivityObject.fecha_nacimiento_activity = `${values.nacimiento.$y}-${month}-${values.nacimiento.$D}`;
    updateactivityObject.genero_activity = values.genero;
    updateactivityObject.id_emp = 1;
    updateactivityObject.id_admin = 1;

    updateactivity(updateactivityObject, selectedRow.id_activity);
    notification.success({
      message: 'Usuario actualizado',
      description: `Los datos han sido actualizados`,
      icon: <SmileOutlined style={{ color: '#108ee9' }} />,
    });
    window.location.reload();
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
      await axios.get(`${BASE_PATH_DB}/activity`)
        .then(response => {
          setactivitys(response.data);
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
      dataIndex: `id_acti`,
      rowScope: 'id',
      defaultSortOrder: 'ascend',
      sorter: (a, b) => a.id_activity - b.id_activity,
    },
    {
      title: 'Nombre',
      dataIndex: 'nombre_acti',
      key: 'name',
      onCell: sharedOnCell,
      filteredValue: [dataSearch],
      onFilter: (value, record) => {
        return (
          String(record.nombre_activity)
            .toLowerCase()
            .includes(value.toLowerCase()) ||
          String(record.id_activity)
            .toLowerCase()
            .includes(value.toLowerCase()) ||
          String(record.correo_activity)
            .toLowerCase()
            .includes(value.toLowerCase())
        );
      }
    },
    {
      title: 'Descripción',
      dataIndex: 'descripcion_acti',
      key: 'lastname',
      onCell: sharedOnCell,
    },
    {
      title: 'Tiempo',
      dataIndex: 'tiempo_acti',
      key: 'email',
      onCell: sharedOnCell,
    },
    {
      title: 'Calorias',
      dataIndex: 'cal_quemadas_acti',
      key: 'birthday',
      onCell: sharedOnCell,
    },
    {
      title: 'Puntos',
      dataIndex: 'puntos_ot_acti',
      key: 'gender',
      onCell: sharedOnCell,
    },
  ];



  const { Search } = Input;

  return (
    <div>
      <Table columns={columns}
        dataSource={activitys}
        bordered
        rowKey={(record) => record.id_activity}
        rowSelection={{
          type: 'radio',
          ...rowSelection,
        }}
        title={() =>
          <Search
            placeholder="Ingrese #, Apellido o Correo"
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
        title="Inserte un usuario"
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
            name="nombre_acti"
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
            name="descripcion_acti"
            label="Descripción"
            rules={[
              {
                type: 'string',
                message: 'Ingrese un nombre valido!',
              },
              {
                required: true,
                message: 'Ingrese un apellido!',
              },
            ]}
          >
            <Input />
          </Form.Item>

          <Form.Item
            name="tiempo_acti"
            label="Tiempo"
            rules={[
              {
                type: 'date',
                message: 'Ingrese una fecha valida!',
                status: false
              },
              {
                required: true,
                message: 'Ingrese una fecha de nacimiento!',
              },
              ({ getFieldValue }) => ({
                validator(_, value) {
                  if (getFieldValue('nacimiento').year() < 2004 && getFieldValue('nacimiento').year() > 1940) {
                    return Promise.resolve();
                  }
                  return Promise.reject(new Error('La fecha ingresada no es valida!'));
                },
              }),
            ]}
          >
           <TimePicker defaultOpenValue={dayjs('00:00:00', 'HH:mm:ss')} />
          </Form.Item>

          <Form.Item
            name="cal_quemadas_acti"
            label="Calorias"
            rules={[
              {
                type: 'float',
                message: 'Ingrese un correo valido!',
              },
              {
                required: true,
                message: 'Ingrese un correo valido!',
              },
            ]}
          >
            <InputNumber min={1} max={10000} defaultValue={50} />
          </Form.Item>

          <Form.Item
            name="puntos_ot_acti"
            label="Puntos"
            rules={[
              {
                  type: 'integer',
                  message: 'Solo numeros enteros',
              },
              {
                required: true,
                message: 'Ingrese una cantidad de puntos!',
              },
            ]}
          >
            <InputNumber min={1} max={100} defaultValue={5}  disabled={true}/>

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
            initialValue={selectedRow.nombre_activity}
            resetFields
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
            name="apellido"
            label="Apellido"
            initialValue={selectedRow.apellido_activity}
            rules={[
              {
                type: 'string',
                message: 'Ingrese un nombre valido!',
              },
              {
                required: true,
                message: 'Ingrese un apellido!',
              },
            ]}
          >
            <Input />
          </Form.Item>

          <Form.Item
            name="correo"
            label="Correo"
            initialValue={selectedRow.correo_activity}
            rules={[
              {
                type: 'email',
                message: 'Ingrese un correo valido!',
              },
              {
                required: true,
                message: 'Ingrese un correo valido!',
              },
            ]}
          >
            <Input />
          </Form.Item>

          <Form.Item
            name="nacimiento"
            label="Fecha de Nacimiento"
            initialValue={dayjs(selectedRow.fecha_nacimiento_activity, 'YYYY-MM-DD')}
            rules={[
              {
                type: 'date',
                message: 'Ingrese una fecha valida!',
                status: false
              },
              {
                required: true,
                message: 'Ingrese una fecha de nacimiento!',
              },
              ({ getFieldValue }) => ({
                validator(_, value) {
                  if (getFieldValue('nacimiento').year() < 2004) {
                    return Promise.resolve();
                  }
                  return Promise.reject(new Error('La fecha ingresada no es valida!'));
                },
              }),
            ]}
          >
            <DatePicker
              format='YYYY-MM-DD'
              disabledTime={true} />
          </Form.Item>

          <Form.Item
            name="genero"
            label="Genero"
            initialValue={selectedRow.genero_activity}
            rules={[
              {
                required: true,
                message: 'Seleccione un genero!',
              },
            ]}
          >
            <Select placeholder="Seleccione su sexo">
              <Option value="Masculino">Masculino</Option>
              <Option value="Femenino">Femenino</Option>
              <Option value="No especificar">No especificar</Option>
            </Select>
          </Form.Item>

          <Form.Item {...tailFormItemLayout}>
            <Button type="primary" htmlType="submit">
              Actualizar
            </Button>
          </Form.Item>
        </Form>
      </Modal>

      <Modal
        title="Desactivar usuario"
        centered
        open={modalDelete}
        okButtonProps={{ danger: true }}
        onOk={() => {
          deleteactivity(selectedRow.id_activity);
          setModalDelete(false);
          notification.warning({
            message: 'Usuario desactivado',
            description: `Los datos han sido eliminados`,
          });
        }}
        onCancel={() => setModalDelete(false)}
      >
        <p>Esta a punto de desactivar al usuario
          {` ${selectedRow.nombre_activity} `}
          {`${selectedRow.apellido_activity} `}
          con ID: {selectedRow.id_activity} </p>

      </Modal>

    </div>
  );
};

export default Activity;