import React from 'react'
import { Outlet, Navigate } from "react-router-dom";
import { Header } from '../components';
const DashboardLayout = () => {
  return (
    <>
        <Header/>
        <main className="flex flex-col items-center md:min-h-screen bg-gray-100 pt-24 w-full">
          <Outlet/>
        </main>
    </>
  )
}

export default DashboardLayout