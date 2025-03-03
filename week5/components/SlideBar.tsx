import React from 'react';
import {
  Drawer,
  DrawerBody,
  DrawerFooter,
  DrawerHeader,
  DrawerOverlay,
  DrawerContent,
  DrawerCloseButton,
  Button,
  useDisclosure,
  VStack,
  Link,
  Text
} from "@chakra-ui/react";
import { MdOutlineMenu } from "react-icons/md";

const SideBar = () => {
  const { isOpen, onOpen, onClose } = useDisclosure();
  const btnRef = React.useRef(null);

  return (
    <>
      <Button
        ref={btnRef}
        onClick={onOpen}
        fontSize="30px"
        backgroundColor='transparent'
        aria-label="Open Menu"
      >
        <MdOutlineMenu />
      </Button>
      <Drawer isOpen={isOpen} placement="right" onClose={onClose} finalFocusRef={btnRef}>
        <DrawerOverlay />
        <DrawerContent>
          <DrawerCloseButton aria-label="Close Menu" />
          <DrawerHeader>Navigation</DrawerHeader>
          <DrawerBody>
            <VStack align="start">
              <Link href="/" style={{ textDecoration: "none" }} aria-label="Home">
                Home
              </Link>
              <Link href="/about" style={{ textDecoration: "none" }} aria-label="About">
                About
              </Link>
              <Link href="/contact" style={{ textDecoration: "none" }} aria-label="Contact">
                Contact
              </Link>
              <Link href="/games" style={{ textDecoration: "none" }} aria-label="Games">
                Games
              </Link>
            </VStack>
          </DrawerBody>
          <DrawerFooter>
            <Text>© 2025 Gaming Website. All rights reserved.</Text>
          </DrawerFooter>
        </DrawerContent>
      </Drawer>
    </>
  );
};

export default SideBar;
