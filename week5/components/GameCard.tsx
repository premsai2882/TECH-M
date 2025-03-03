import {
    Badge,
    Card,
    CardBody,
    CardHeader,
    GridItem,
    HStack,
    Link,
    SimpleGrid,
    StackDivider,
    Tag,
    TagLabel,
    TagLeftIcon,
    Button,
    ButtonGroup,
    Box,
    Text,
    Heading,
    Image,
    Stack
  } from '@chakra-ui/react';
  import { useEffect, useState } from 'react';
  import { IoIosAdd } from "react-icons/io";
  import { FaStar } from "react-icons/fa";
  import axios from 'axios';
  import React from 'react';
  
  const GameCard = () => {
    const pageSize = 4;
    const [page, setPage] = useState(1);
    const [response, setResponse] = useState([]);
  
    useEffect(() => {
      const fetchData = async () => {
        const result = await axios.get(
          'https://api.rawg.io/api/games?key=8a48d53ca9c84722a12f731e4912a94e'
        );
        setResponse(result.data.results);
      };
      fetchData();
    }, []);
  
    const startRange = (page - 1) * pageSize;
    const endRange = startRange + pageSize;
    const visibleItems = response.slice(startRange, endRange);
  
    return (
      <>
        <SimpleGrid w='100%' minChildWidth='260px' p={6} gap={6}>
          {visibleItems.map((item, key) => (
            <GridItem w='100%' key={key}>
              <Card maxW='sm' boxShadow='4px 4px 15px rgb(0,0,0,0.15)'>
                <CardHeader>
                  <Image
                    src={item.background_image || 'fallback-image-url.jpg'}
                    alt={item.name}
                    h='200px'
                    objectFit='cover'
                  />
                  <Stack mt='6' spacing='3'>
                    <Heading size='sm'>{item.name}</Heading>
                  </Stack>
                  <HStack spacing={1} pt={2}>
                    <Tag size='sm' variant='subtle' colorScheme='cyan'>
                      <TagLeftIcon boxSize='18px' as={IoIosAdd} />
                      <TagLabel>{item.suggestions_count}</TagLabel>
                    </Tag>
                    <Tag size='sm'>
                      <TagLeftIcon boxSize='15px' as={FaStar} style={{ color: 'gold' }} />
                      <TagLabel>{item.rating}</TagLabel>
                    </Tag>
                  </HStack>
                </CardHeader>
                <CardBody id={key.toString()}>
                  <Stack px={2} divider={<StackDivider />} spacing='1'>
                    <Box display='flex' justifyContent='space-between'>
                      <Text fontSize='sm'>Release Date:</Text>
                      <Text fontSize='sm'>{item.released}</Text>
                    </Box>
                    <Box display='flex' justifyContent='space-between'>
                      <Text fontSize='sm'>Genres</Text>
                      <GridItem fontSize='sm'>
                        {item.genres.map((genre, index) => (
                          <Badge key={index} display='inline' mx='1' colorScheme='purple'>
                            {genre.name}
                          </Badge>
                        ))}
                      </GridItem>
                    </Box>
                  </Stack>
                  <Stack px={2} py={2}>
                    <ButtonGroup display='flex' justifyContent='space-between'>
                      <Button variant='ghost' colorScheme='green'>
                        Buy now
                      </Button>
                      <Link href={`/details/${item.id}`}>
                        <Button variant='ghost' colorScheme='orange'>
                          View Details
                        </Button>
                      </Link>
                    </ButtonGroup>
                  </Stack>
                </CardBody>
              </Card>
            </GridItem>
          ))}
        </SimpleGrid>
        <SimpleGrid display='flex' justifyContent='center'>
          <Button
            m='4'
            onClick={() => (page > 1 ? setPage(page - 1) : null)}
            backgroundColor='teal.500'
          >
            Prev
          </Button>
          <Button
            m='4'
            onClick={() => (page < Math.floor(response.length / pageSize) ? setPage(page + 1) : null)}
            backgroundColor='teal.500'
          >
            Next
          </Button>
        </SimpleGrid>
      </>
    );
  };
  
  export default GameCard;
  