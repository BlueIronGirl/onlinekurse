function initApp() {
    try {
        connectDatabase();
    } catch (error) {
        console.log(error.message);
    }
}

function connectDatabase() {
    const didConnect = database.connect();
    if (!didConnect) {
        throw new Error('Could not connect!');
    }
}

function determineSupportAgent(ticket) {
    if (ticket.requestType === 'unknown') {
        return findStandardAgent();
    }
    return findAgentByRequestType(ticket.requestType);
}

function validateUser(email, password) {
    if (!isValid(email, password)) {
        console.log('Invalid input!');
        return false;
    }
    return true;
}

function isValid(email, password) {
    return email.includes('@') && password.length >= 7;
}