const countdown = () => {
    const conferenceDate = new Date('2025-03-10').getTime();
    const now = new Date().getTime();
    const difference = conferenceDate - now;
    
    if (difference >= 0) {
        const days = Math.floor(difference / (1000 * 60 * 60 * 24));
        document.getElementById('countdown').innerText = `${days} days to go!`;
    } else {
        document.getElementById('countdown').innerText = 'The event has passed!';
    }
};

setInterval(countdown, 1000);
