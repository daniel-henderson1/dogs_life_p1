import React from 'react'
import HeroDetail from './HeroDetail'
import Row from 'react-bootstrap/Row'
import { getAllHeroes } from '../services/hero-service'
import { useState } from 'react'
import { useEffect } from 'react'

const AllHeroes = () => {
  const [total, setTotal] = useState(0);
  const totalCountHandler = (name) =>{
    console.log(name)
    setTotal(total+1);
  }
  
  const [heroes, setHeroes] = useState([]);

  useEffect(()=>{
    getHeroesFromAPI();},[]
  );
  const getHeroesFromAPI = ()=>{}

  getAllHeroes()
  .then(res => {
      setHeroes(res.data);
  })
  .catch(err => {
      setHeroes([]);
      console.log(err);
  })

  return (
  <>
    <h1> Total count is: {total}</h1>
    <Row >
    {heroes.map(hero => (
        <div className='container' key={hero.id.toString()}>
          <HeroDetail info={hero} parentCount={totalCountHandler} />
        </div>
     ))}
    </Row>

  </>
)


  }

export default AllHeroes