// Fetch and display speakers
fetch('assets/data/speakers.json')
    .then(response => response.json())
    .then(data => {
        const speakerList = document.getElementById('speaker-list');
        data.forEach(speaker => {
            speakerList.innerHTML += `
                <div class="speaker">
                    <img src="assets/images/${speaker.image}" alt="${speaker.name}">
                    <h3>${speaker.name}</h3>
                    <p>${speaker.bio}</p>
                </div>
            `;
        });
    });

// Fetch and display schedule
fetch('assets/data/schedule.json')
    .then(response => response.json())
    .then(data => {
        const scheduleList = document.getElementById('schedule-list');
        data.forEach(session => {
            scheduleList.innerHTML += `
                <div class="session">
                    <h3>${session.title}</h3>
                    <p>${session.time} | ${session.track}</p>
                </div>
            `;
        });
    });