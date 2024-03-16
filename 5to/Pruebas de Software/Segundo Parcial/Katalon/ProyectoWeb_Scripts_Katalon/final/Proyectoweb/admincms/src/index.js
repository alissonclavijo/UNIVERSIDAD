import React, { StrictMode } from 'react';
import { createRoot } from 'react-dom/client';
import App from './App';
import './index.css'


const universal_container = document.getElementById('root');
const root = createRoot(universal_container);


root.render(
  <StrictMode>
      <App />
  </StrictMode>
);