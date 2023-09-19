import React from 'react';
import axios from 'axios';
import { useState, useEffect } from 'react';
import { BASE_PATH_DB } from '../utils/config';
import { Table } from 'antd';
import { Row, Col } from 'antd';
import { Button, Input, Modal, notification } from 'antd';
import { DeleteOutlined, EditOutlined, PlusCircleOutlined,
          SmileOutlined } from '@ant-design/icons';
import { Checkbox, Form, Select, DatePicker } from 'antd';
import { createUser, updateUser, deleteUser } from '../services/user_services';
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

const User = () => {

  const [users, setUsers] = useState([]);

  const [selectedRow, setSelectedRow] = useState([]);

  const [dataSearch, setDataSearch] = useState("");

  const [modalInsert, setModalInsert] = useState(false);

  const [modalUpdate, setModalUpdate] = useState(false);

  const [modalDelete, setModalDelete] = useState(false);

  const [disblableButton, setDisableButton] = useState(true);

  const [form] = Form.useForm();
  const [form2] = Form.useForm();

  const onFinish = (values) => {
    const updateUserObject = {};
    const month = values.nacimiento.$M + 1;

    updateUserObject.nombre_user = values.nombre;
    updateUserObject.apellido_user = values.apellido;
    updateUserObject.correo_user = values.correo;
    updateUserObject.contrasena_user = `${values.apellido}${values.nacimiento.$y}`;
    updateUserObject.fecha_nacimiento_user = `${values.nacimiento.$y}-${month}-${values.nacimiento.$D}`;
    updateUserObject.genero_user = values.genero;
    updateUserObject.id_emp = 1;
    updateUserObject.id_admin = 1;

    createUser(updateUserObject);

    notification.success({
      message: 'Usuario creado',
      description: `Notifique al usuario`,
      icon: <SmileOutlined style={{ color: '#108ee9' }} />,});

  };

  const onFinishUpdate = (values) => {
    const updateUserObject = {};
    const month = values.nacimiento.$M + 1;

    updateUserObject.nombre_user = values.nombre;
    updateUserObject.apellido_user = values.apellido;
    updateUserObject.correo_user = values.correo;
    updateUserObject.contrasena_user = `${values.apellido}${values.nacimiento.$y}`;
    updateUserObject.fecha_nacimiento_user = `${values.nacimiento.$y}-${month}-${values.nacimiento.$D}`;
    updateUserObject.genero_user = values.genero;
    updateUserObject.id_emp = 1;
    updateUserObject.id_admin = 1;

    updateUser(updateUserObject, selectedRow.id_user);
    notification.success({
      message: 'Usuario actualizado',
      description: `Los datos han sido actualizados`,
      icon: <SmileOutlined style={{ color: '#108ee9' }} />,});
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
      await axios.get(`${BASE_PATH_DB}/user`)
        .then(response => {
          setUsers(response.data);
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
      dataIndex: `id_user`,
      rowScope: 'id',
      defaultSortOrder: 'ascend',
      sorter: (a, b) => a.id_user - b.id_user,
    },
    {
      title: 'Nombre',
      dataIndex: 'nombre_user',
      key: 'name',
      onCell: sharedOnCell,
      filteredValue: [dataSearch],
      onFilter: (value, record) => {
        return (
          String(record.nombre_user)
            .toLowerCase()
            .includes(value.toLowerCase()) ||
          String(record.id_user)
            .toLowerCase()
            .includes(value.toLowerCase()) ||
          String(record.correo_user)
            .toLowerCase()
            .includes(value.toLowerCase())
        );
      }
    },
    {
      title: 'Apellido',
      dataIndex: 'apellido_user',
      key: 'lastname',
      onCell: sharedOnCell,
    },
    {
      title: 'Correo',
      dataIndex: 'correo_user',
      key: 'email',
      onCell: sharedOnCell,
    },
    {
      title: 'Fecha de Nacimiento',
      dataIndex: 'fecha_nacimiento_user',
      key: 'birthday',
      onCell: sharedOnCell,
    },
    {
      title: 'Genero',
      dataIndex: 'genero_user',
      key: 'gender',
      onCell: sharedOnCell,
    },
  ];



  const { Search } = Input;

  return (
    <div>
      <Table columns={columns}
        dataSource={users}
        bordered
        rowKey={(record) => record.id_user}
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
            name="apellido"
            label="Apellido"
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
            <DatePicker
              format='YYYY-MM-DD'
              disabledTime={true} />
          </Form.Item>

          <Form.Item
            name="genero"
            label="Genero"
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
            initialValue={selectedRow.nombre_user}
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
            initialValue={selectedRow.apellido_user}
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
            initialValue={selectedRow.correo_user}
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
            initialValue={dayjs(selectedRow.fecha_nacimiento_user, 'YYYY-MM-DD')}
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
            initialValue={selectedRow.genero_user}
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
        okButtonProps={{danger:true}}
        onOk={() => {
          deleteUser(selectedRow.id_user);
          setModalDelete(false);
          notification.warning({
            message: 'Usuario desactivado',
            description: `Los datos han sido eliminados`,});
        }}
        onCancel={() => setModalDelete(false)}
      >
        <p>Esta a punto de desactivar al usuario
            {` ${selectedRow.nombre_user} `} 
            {`${selectedRow.apellido_user} `} 
            con ID: {selectedRow.id_user} </p>

      </Modal>

    </div>
  );
};

export default User;