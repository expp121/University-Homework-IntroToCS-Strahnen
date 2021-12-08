// The following code will clear any extraneous input:

//#std::cin.ignore(std::numeric_limits<std::streamsize>::max(), '\n');
//cin has a buffer were input is stored, and this cleans the buffer until '\n' or until some value(how many symbols)
// in this case: std::numeric_limits<std::streamsize>::max() symbols

// The following code will test for and fix failed extractions or overflow:

//if cin fails to extrac input it goes into a 'failure mode', resulting in not executing following 'cin' commands
//#if (std::cin.fail()) // has a previous extraction failed or overflowed?
//#{
//#    // yep, so let's handle the failure
//#    std::cin.clear(); // put us back in 'normal' operation mode
//#    std::cin.ignore(std::numeric_limits<std::streamsize>::max(), '\n'); // and remove the bad input
//#}