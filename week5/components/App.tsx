import React from 'react';
import { Grid, GridItem } from '@chakra-ui/react';
import { Routes, Route, BrowserRouter } from 'react-router-dom';
import NavBar from "./components/NavBar";
import GameCard from "./components/GameCard";
import Footer from "./components/Footer";
import GameDetails from "./components/GameDetails";

function App() {
  return (
    <BrowserRouter>
      <Grid templateAreas={`"nav" "main" "footer"`}>
        <GridItem area={'nav'} bg={"teal"}>
          <NavBar />
        </GridItem>
        <GridItem area={'main'}>
          <Routes>
            <Route path="/" element={<GameCard />} />
            <Route path="details/:resId" element={<GameDetails />} />
          </Routes>
        </GridItem>
        <GridItem area={'footer'}>
          <Footer />
        </GridItem>
      </Grid>
    </BrowserRouter>
  );
}

export default App;
