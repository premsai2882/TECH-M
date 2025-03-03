import { HStack, Switch, useColorMode } from '@chakra-ui/react'
import React from 'react';
//using reat api endpoint is known as consuming api
//this is a functional component

function DarkSwitch() {
   
  const {colorMode,toggleColorMode} = useColorMode();

  return (
    <HStack>
        <Switch isChecked={colorMode == 'dark'}onChange={toggleColorMode } colorScheme='green' ></Switch>
    </HStack>
  )
}

export default DarkSwitch