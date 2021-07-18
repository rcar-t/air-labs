export class Airport {
    constructor(
        public icao: string,
        public name: string, 
        public lat: number,
        public long: number, 
        public alt: number
    ) {}
}