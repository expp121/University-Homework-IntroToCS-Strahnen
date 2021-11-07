#include <bitset>
#include <iostream>

std::bitset<4> rotl_noCheck(std::bitset<4> bits)
{
    return (bits << 1) | (bits >> 3);
}

std::bitset<4> rotl(std::bitset<4> bits)
{
    if (bits.test(3))
    {
        bits <<= 1;
        bits.set(0);
    }
    else
        bits <<= 1;

    return bits;
}

int main()
{
    constexpr std::uint8_t mask0{0b0000'0001}; // represents bit 0
    constexpr std::uint8_t mask1{0b0000'0010}; // represents bit 1
    constexpr std::uint8_t mask2{0b0000'0100}; // represents bit 2
    constexpr std::uint8_t mask3{0b0000'1000}; // represents bit 3
    constexpr std::uint8_t mask4{0b0001'0000}; // represents bit 4
    constexpr std::uint8_t mask5{0b0010'0000}; // represents bit 5
    constexpr std::uint8_t mask6{0b0100'0000}; // represents bit 6
    constexpr std::uint8_t mask7{0b1000'0000}; // represents bit 7
    /**
     * Setting a bit
    */

    std::uint8_t flags{0b0000'0101}; // 8 bits in size means room for 8 flags

    std::cout << "bit 1 is " << ((flags & mask1) ? "on\n" : "off\n");

    flags |= mask1; // turn on bit 1

    std::cout << "bit 1 is " << ((flags & mask1) ? "on\n" : "off\n");

    /**
     * Resetting a bit
    */
    std::cout << "bit 2 is " << ((flags & mask2) ? "on\n" : "off\n");

    flags &= ~mask2; // turn off bit 2

    std::cout << "bit 2 is " << ((flags & mask2) ? "on\n" : "off\n");

    /**
     * Flipping a bit
    */
    std::cout << "bit 2 is " << ((flags & mask2) ? "on\n" : "off\n");
    flags ^= mask2; // flip bit 2
    std::cout << "bit 2 is " << ((flags & mask2) ? "on\n" : "off\n");
    flags ^= mask2; // flip bit 2
    std::cout << "bit 2 is " << ((flags & mask2) ? "on\n" : "off\n");
    

    std::bitset<4>
        bits1{0b0001};
    std::cout << rotl(bits1) << '\n';

    std::bitset<4> bits2{0b1001};
    std::cout << rotl(bits2) << '\n';

    return 0;
}