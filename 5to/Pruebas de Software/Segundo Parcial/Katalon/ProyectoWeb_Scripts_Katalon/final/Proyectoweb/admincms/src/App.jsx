import React from 'react';
import {
  BrowserRouter as Router,
  Routes,
  Route
} from 'react-router-dom';
import SignIn from './pages/sign_in';
import Activity from './pages/activity';
import Admin from './pages/admin';
import Register from './pages/register';
import Reward from './pages/reward';
import User from './pages/user';
import Winner from './pages/winner';
import { Layout, theme } from 'antd';
import Footer from './components/footer';
import Sider from './components/sider';
import Header from './components/header';


function App() {

  const {
    token: { colorBgContainer },
} = theme.useToken();

  //const {user, isLoading} = AuthService();
  const user = 'is_login';
  if (user === 'is_logout') {
    return (
      <Router>
        <Routes>
          <Route path='/' element={<SignIn />} />
        </Routes>
      </Router>
    );
  } else if (user === 'is_login') {
    return (
          <Router>
                  <Layout
        style={{
          minHeight: '100vh',
        }}
      >
        <Sider />
        <Layout>
          <Header />
          <Layout.Content
            style={{
                margin: '0 16px',
            }}
        >
            <div
                style={{
                    padding: 24,
                    minHeight: 360,
                    background: colorBgContainer,
                }}
            >
            <Routes>
              <Route path='/activity' element={<Activity />} />
              <Route path='/admin' element={<Admin />} />
              <Route path='/register' element={<Register />} />
              <Route path='/reward' element={<Reward />} />
              <Route path='/user' element={<User />} />
              <Route path='/winner' element={<Winner />} />
            </Routes>
            </div>
        </Layout.Content>
            <Footer />
        </Layout>
      </Layout>
          </Router>
    );
  } else if (user === 'super') {
    return (
      <Router>
        <Routes>
          <Route path='/admin' element={<Admin />} />
        </Routes>
      </Router>
    );
  }

  return (
    <Router>
      <Routes>
        <Route path='/' element={<SignIn />} />
      </Routes>
    </Router>
  );

}

export default App;
