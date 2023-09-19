import React from 'react';
import { Col, Row} from 'antd';
import { Button, Form, Input } from 'antd';
import { LockOutlined, UserOutlined } from '@ant-design/icons';
import '../css/sign_in.css';

function SignIn() {

  const onFinish = (values) => {
    console.log('Success:', values);
  };
  const onFinishFailed = (errorInfo) => {
    console.log('Failed:', errorInfo);
  };

  return (
    <div className='sign-page'>
      <Row className='sign-r1'>
      </Row>
      <Row className='sign-container'>
        <Col span={2}> </Col>
        <Col span={10} className='sign-image-box'></Col>
          <Col span={10} className='sign-in-form'>
          <Form
            name="basic"
            labelCol={{
              span: 16,
            }}
            wrapperCol={{
              span: 16,
            }}
            style={{
              maxWidth: 800,
            }}
            initialValues={{
              remember: true,
            }}
            onFinish={onFinish}
            onFinishFailed={onFinishFailed}
            autoComplete="off"
            className='only-form'
          >
            <Form.Item
              name="email"
              rules={[
                {
                  required: true,
                  message: 'Por favor ingrese su email!',
                },
                {
                  type: 'email',
                  message: 'Ingrese un correo valido',
                }
              ]}
            >
               <Input prefix={<UserOutlined className="site-form-item-icon" />} placeholder='Correo'/>
            </Form.Item>

            <Form.Item
              name="password"
              rules={[
                {
                  required: true,
                  message: 'Por favor ingrese su contraseña!',
                },
              ]}
            >
              <Input.Password prefix={<LockOutlined className="site-form-item-icon" />} placeholder="Contraseña" />
            </Form.Item>

            <Form.Item
            >
              <Button type='primary' htmlType="submit">
                Ingresar
              </Button>
            </Form.Item>
          </Form>
        </Col>
        <Col span={2}> </Col>
      </Row>
      <Row className='sign-r2'>
      </Row>
    </div>
  );
}
export default SignIn;