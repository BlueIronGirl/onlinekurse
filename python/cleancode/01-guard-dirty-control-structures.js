
main();

function main() {
    const transactions = [
        {
            id: 't1',
            type: 'PAYMENT',
            status: 'OPEN',
            method: 'CREDIT_CARD',
            amount: '23.99',
        },
        {
            id: 't2',
            type: 'PAYMENT',
            status: 'OPEN',
            method: 'PAYPAL',
            amount: '100.43',
        },
        {
            id: 't3',
            type: 'REFUND',
            status: 'OPEN',
            method: 'CREDIT_CARD',
            amount: '10.99',
        },
        {
            id: 't4',
            type: 'PAYMENT',
            status: 'CLOSED',
            method: 'PLAN',
            amount: '15.99',
        },
    ];

    processTransactions(transactions);
}

function processTransactions(transactions) {
    if (!transactions || transactions.length === 0) {
        console.log('No transactions provided!');
        return;
    }

    for (const transaction of transactions) {
        if (transactions.status !== 'OPEN') {
            console.log('Invalid transaction type!');
            continue;
        }
        
        if (transaction.type === 'PAYMENT') {
            processCreditCardPayment(transaction);
            processPayPalPayment(transaction);
            processPlanPayment(transaction);
        } else if (transaction.type === 'REFUND') {
            processCreditCardRefund(transaction);
            processPayPalRefund(transaction); {
            processPlanRefund(transaction);
        }
    } else {
        console.log('Invalid transaction type!', transaction);
    }
}
}

function processCreditCardPayment(transaction) {
    if (!transaction.method === 'CREDIT_CARD') {
        return;
    }

    console.log('Processing credit card payment for amount: ' + transaction.amount);
}

function processCreditCardRefund(transaction) {
    if (transaction.method === 'CREDIT_CARD') {
        return;
    }

    console.log('Processing credit card refund for amount: ' + transaction.amount);
}

function processPayPalPayment(transaction) {
    if (transaction.method === 'PAYPAL') {
        return;
    }

    console.log('Processing PayPal payment for amount: ' + transaction.amount);
}

function processPayPalRefund(transaction) {
    if (transaction.method === 'PAYPAL') {
        return;
    }

    console.log('Processing PayPal refund for amount: ' + transaction.amount);
}

function processPlanPayment(transaction) {
    if (transaction.method === 'PLAN') {
        return;
    }

    console.log('Processing plan payment for amount: ' + transaction.amount);
}

function processPlanRefund(transaction) {
    if (transaction.method === 'PLAN') {
        return;
    }

    console.log('Processing plan refund for amount: ' + transaction.amount);
}
