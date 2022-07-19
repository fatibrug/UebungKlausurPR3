package FileIO;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class AddressManager {

    private ArrayList<Address> addresses = new ArrayList<>();

    public void add(Address a){
        addresses.add(a);
    }

    public ArrayList<Address> getAddresses() {
        return addresses;
    }

    public void exportToCvs(String path, String separator) throws AddressExportException{

        BufferedWriter bufferedWriter = null;

        try {
            FileWriter fileWriter = new FileWriter(path);
            bufferedWriter = new BufferedWriter(fileWriter);

            for(Address addresses : getAddresses()){
                bufferedWriter.write(addresses.getFirstname() + separator + addresses.getLastname() +
                        separator + addresses.getMobilNumber() + separator + addresses.getEmail());
                bufferedWriter.newLine();

                System.out.println("Address has been written to File: " + addresses);
            }
            bufferedWriter.flush();


        } catch (IOException e) {
           throw new AddressExportException();
        } finally {
            try {
                if(bufferedWriter != null){
                    bufferedWriter.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public List<Address> loadFromCsv(String path, String separator) throws AddressLoadWrongFormatException, AddressLoadException {
        List<Address> addressList = new ArrayList<>();
        BufferedReader bufferedReader = null;

        try {
            FileReader fr = new FileReader(path);
            bufferedReader = new BufferedReader(fr);

            String temp;
            while (((temp = bufferedReader.readLine()) != null)) {
                String[] tempp = temp.split(separator);
                if (tempp.length != 4) {
                    throw new AddressLoadWrongFormatException("4 Spalten erwartet!");
                }
                addressList.add(new Address(tempp[0], tempp[1], tempp[2], tempp[3]));
            }
        } catch (IOException e) {
            throw new AddressLoadException(e);
        } finally {
            try {
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
            } catch (IOException e) {
                throw new AddressLoadException(e);
            }
        }
        return addressList;
    }


}
