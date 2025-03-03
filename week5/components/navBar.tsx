import React from 'react';
import {
  HStack,
  Text,
  Image,
  Box,
  SimpleGrid,
} from '@chakra-ui/react';
import { Link } from 'react-router-dom';
import logo from '../assets/logo.png';
import DarkSwitch from './DarkSwitch';
import SlideBar from './SlideBar';

const NavBar = () => {
  return (
    <HStack justifyContent='space-between' px={6}>
      <Box display='flex' alignItems='center'>
        <Image src={logo} alt='logo' boxSize='90px' />
        <Link to='/'>
          <Text fontSize='20px' fontWeight='bold'>Gamers Hub</Text>
        </Link>
      </Box>

      <Box display='flex' alignItems='center'>
        <DarkSwitch />
        <SlideBar />
      </Box>   
    </HStack>
  );
}

export default NavBar;
