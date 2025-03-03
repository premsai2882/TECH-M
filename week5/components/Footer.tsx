import { SimpleGrid, Box, Text, HStack, Icon, Link } from "@chakra-ui/react";
import React from "react";
import { FaFacebook, FaTwitter, FaInstagram } from "react-icons/fa";

const Footer = () => {
  return (
    <SimpleGrid
      justifyItems="center"
      w="100%"
      minChildWidth="260px"
      p={6}
      gap={6}
      minHeight="105.5px"
      backgroundColor="gray.700"
      color="white"
    >
      <Box textAlign="center">
        <Text fontSize="lg" fontWeight="bold">
          Gamers Hub
        </Text>
        <Text>© 2025 Gaming Website. All rights reserved.</Text>
      </Box>
      <Box textAlign="center">
        <Text fontSize="lg" fontWeight="bold">Links</Text>
        <Box display="flex" justifyContent="center">
          <Link href="/" px={2}>
            Home
          </Link>
          <Link href="/about" px={2}>
            About
          </Link>
          <Link href="/contact" px={2}>
            Contact
          </Link>
        </Box>
      </Box>
      <Box textAlign="center">
        <Text fontSize="lg" fontWeight="bold">Follow Us</Text>
        <HStack spacing={4} justifyContent="center">
          <Link href="https://www.facebook.com" isExternal aria-label="Facebook">
            <Icon as={FaFacebook} w={6} h={6} />
          </Link>
          <Link href="https://www.twitter.com" isExternal aria-label="Twitter">
            <Icon as={FaTwitter} w={6} h={6} />
          </Link>
          <Link href="https://www.instagram.com" isExternal aria-label="Instagram">
            <Icon as={FaInstagram} w={6} h={6} />
          </Link>
        </HStack>
      </Box>
    </SimpleGrid>
  );
};

export default Footer;
